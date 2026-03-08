package com.api.base;

import com.api.model.request.ProfileRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService {

	private static final  String BASE_PATH ="api/users";
	
	
	
	
	
	public Response updateProfile(Object token ,ProfileRequest payload) {
		return putRequest( token ,payload,BASE_PATH+ "/profile");
	}
	
	
	
	


	

	
	
}
