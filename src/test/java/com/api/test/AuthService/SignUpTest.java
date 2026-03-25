 package com.api.test.AuthService;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.dataProvider.SignUpDataProvider;
import com.api.model.request.SignUpRequest;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class SignUpTest {
	
	
	@Test(dataProvider = "SignUpTestDataProvider",dataProviderClass = SignUpDataProvider.class,description = "Testing for sign up  ")
	public void signUpTest(	SignUpRequest signUpRequest) {
		
		 
		 
		   AuthService authService = new AuthService();
		 Response response =  authService.signUp(signUpRequest);
	
	
	   System.out.println(response.asPrettyString());
		
		
		
	}

}
