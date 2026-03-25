package com.api.test.UserManagementServiceTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserManagementService;
import com.api.dataProvider.UpdateProfileDataProvider;
import com.api.model.request.ProfileRequest;
import com.api.utility.AuthHelper;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	
	@Test(dataProvider = "UpdateProfileDataProvider" ,dataProviderClass = UpdateProfileDataProvider.class ,
			description = "Update profile with test data from json")
	
	public void updateProfileTest(ProfileRequest profileRequest) {
		
		
	String token =	AuthHelper.getAuthToken();

	
	
	 
	UserManagementService profileService = new UserManagementService();
	Response response =profileService.updateProfile(token, profileRequest);
	
	Assert.assertEquals(response.statusCode(), 200);
	
	
	System.out.println(response.asPrettyString());
	}

}
