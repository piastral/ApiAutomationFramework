package com.api.base;

import com.api.models.database.Payment;

import io.restassured.response.Response;

public class PaymentService extends BaseService {
	
	public Response createPayment(Object token ,Payment payload) {
	  return postRequest(token, payload);
	}

}
