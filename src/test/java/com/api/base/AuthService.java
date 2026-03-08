package com.api.base;


import com.api.model.request.LoginRequest;
import com.api.model.request.SignUpRequest;


import io.restassured.response.Response;

public class AuthService extends BaseService {
	
	private static final  String BASE_PATH ="api/auth";
	
	
	//login as end point 
	 public Response login(LoginRequest payload) {
		 
		return postRequest(payload, BASE_PATH + "login");
	 }
	 
	 //forgot password as end point
	 
	public Response signUp (SignUpRequest signUpRequest){
		return postRequest(signUpRequest ,BASE_PATH+ "signup");
	 }
	
	
	 
}
