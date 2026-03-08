package com.api.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.api.model.request.LoginRequest;
import com.api.model.request.SignUpRequest;
import com.google.gson.Gson;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

public class JsonReaderUtility {


	
	public static List<LoginRequest> readLoginTestData () throws FileNotFoundException {
		Gson gson = new Gson();
		File file = new File (System.getProperty("user.dir") + "/src/test/resources/testData/auth-service/login.json");
		 
		 FileReader fileReader = new FileReader(file);
		 Type loginListType = new TypeToken<List<LoginRequest>>() {}.getType();
		 
	List<LoginRequest>loginRequestData=	 gson.fromJson(fileReader, loginListType);
	
	return loginRequestData;
		
		
	}
	
	
	 
	
	public static List<SignUpRequest> signUpTestData () throws FileNotFoundException {
		Gson gson = new Gson();
		File file = new File (System.getProperty("user.dir") + "/src/test/resources/testData/auth-service/SignUp.json");
		 
		 FileReader fileReader = new FileReader(file);
		 Type loginListType = new TypeToken<List<SignUpRequest>>() {}.getType();
		 
	List<SignUpRequest>signUpRequestData=	 gson.fromJson(fileReader, loginListType);
	
	return signUpRequestData;
		
		
	}
	



}
