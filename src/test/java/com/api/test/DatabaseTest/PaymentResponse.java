package com.api.test.DatabaseTest;

public class PaymentResponse {
	
	private String paymentID;

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public PaymentResponse(String paymentID) {
		super();
		this.paymentID = paymentID;
	}

	@Override
	public String toString() {
		return "PaymentResponse [paymentID=" + paymentID + "]";
	}
	

}
