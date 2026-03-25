package com.api.models.database;



import java.sql.Timestamp;

/**
 * Payment model - represents payment record from database
 */
public class Payment {
    
    private String paymentId;
    private Double amount;
    private String status;
    private String accountId;
    private Timestamp createdAt;
    
    // Getters and Setters
    
    public String getPaymentId() {
        return paymentId;
    }
    
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", amount=" + amount + 
               ", status=" + status + ", accountId=" + accountId + 
               ", createdAt=" + createdAt + "]";
    }
}