package com.api.test.DatabaseTest;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.api.base.PaymentService;
import com.api.models.database.Payment;
import com.api.utility.AuthHelper;
import com.api.utility.DBUtils;

import io.restassured.response.Response;

public class CreatePaymentWithDBValidationTest {
    
    @Test(description = "Create payment and validate in database")
    public void testCreatePaymentWithDBValidation() throws Exception {
        
        // STEP 1: Get authentication token
    String token = AuthHelper.getAuthToken();
        // STEP 2: Create payment request
        Payment paymentRequest = new Payment();
        
        // STEP 3: Call Create Payment API
        PaymentService paymentService = new PaymentService();
        Response response = paymentService.createPayment(token, paymentRequest);
        
        // STEP 4: Validate API response
        Assert.assertEquals(response.statusCode(), 201, 
            "Payment creation should return 201 Created");
        
        PaymentResponse paymentResponse = response.as(PaymentResponse.class);
        
        
        String paymentId = paymentResponse.getPaymentID();
        
        Assert.assertNotNull(paymentId, "Payment ID should not be null");
       // Assert.assertEquals(paymentResponse.getStatus(), "SUCCESS", 
          //  "API should return SUCCESS status");
        
        System.out.println("✅ API Response validated");
        System.out.println("Payment ID: " + paymentId);
        
        
        
        // STEP 5: Wait for payment to be saved in database (async operation)
        Payment dbPayment = DBUtils.waitForPayment(paymentId, 10); // Wait max 10 seconds
       //==============================================================================================================
        
    
        
        
        Assert.assertNotNull(dbPayment, 
            "Payment should exist in database!");
        
        // STEP 6: Validate database data matches API request
        Assert.assertEquals(dbPayment.getPaymentId(), paymentId, 
            "Payment ID mismatch!");
        
        Assert.assertEquals(dbPayment.getAmount(), 100.00, 0.01, 
            "Amount mismatch! Expected: 100.00, Found in DB: " + dbPayment.getAmount());
        
        Assert.assertEquals(dbPayment.getStatus(), "COMPLETED", 
            "Payment status should be COMPLETED in database");
        
        Assert.assertEquals(dbPayment.getAccountId(), "ACC123", 
            "Account ID mismatch!");
        
        System.out.println("✅ Database validation PASSED!");
        System.out.println("DB Record: " + dbPayment);
    }
    
    @AfterClass
    public void tearDown() {
        // Close database connection after all tests
        DBUtils.closeConnection();
    }
}
  /*
   * 
   *   ## **STEP 6: How It Works (Flow)**
```
1. Test calls Payment API
    ↓
2. API returns: { "paymentId": "PAY123", "status": "SUCCESS" }
    ↓
3. Test validates API response ✅
    ↓
4. Test calls: DBUtils.waitForPayment("PAY123", 10)
    ↓
5. DBUtils queries database every 1 second (max 10 attempts)
    ↓
    Attempt 1: SELECT * FROM payments WHERE payment_id = 'PAY123'
    → Not found, wait 1 second
    ↓
    Attempt 2: Query again
    → Not found, wait 1 second
    ↓
    Attempt 3: Query again
    → Found! ✅
    ↓
6. DBUtils returns Payment object with database data
    ↓
7. Test validates:
    - Amount = 100.00 ✅
    - Status = COMPLETED ✅
    - Account ID = ACC123 ✅
    ↓
8. Test PASSES ✅
```

---

## **STEP 7: Handling Async Operations**

**Problem:**
```
API returns immediately (200 OK)
    ↓
But database update happens 5 seconds later
    ↓
If you query immediately → Record not found! ❌


*/
  

