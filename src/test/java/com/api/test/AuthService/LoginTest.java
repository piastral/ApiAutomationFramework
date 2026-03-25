package com.api.test.AuthService;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.dataProvider.LoginDataProvider;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;
import com.api.utility.JsonReaderUtility;

import io.restassured.response.Response;

public class LoginTest {
	
	
	
	@Test(dataProvider = "LoginTestDataProvider" ,dataProviderClass = LoginDataProvider.class,description = "Test login with multiple sets")
	public void loginTest(LoginRequest loginRequest) throws FileNotFoundException {
		
	
		
		
		
		  AuthService authService = new AuthService();
		 Response response =    authService.login(loginRequest);
	 
		 
	LoginResponse loginResponse=	 response.as(LoginResponse.class);
	
	
	
	//==================================================*******************==================
     
	
	  System.out.println(loginResponse.getStatus());
	  System.out.println(response.asPrettyString());
		
	  Assert.assertEquals(loginResponse.getMessage(), "You must be logged in to access this resource");
	  
	  Assert.assertTrue(response.statusCode() == 200 || 
              response.statusCode() == 401 || 
              response.statusCode() == 400,
              "Unexpected status code");
	  
	  
	   System.out.println("✅ Test completed for: " + loginRequest.getUsername());
       System.out.println("==========================================");

 
	}

}
