package com.api.dataProvider;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.model.request.LoginRequest;
import com.api.model.request.SignUpRequest;
import com.api.utility.JsonReaderUtility;

public class SignUpDataProvider {
	
	

	@DataProvider(name="SignUpTestDataProvider")
	 public static  Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		
		 
		
		     List<SignUpRequest> signUpData= JsonReaderUtility.signUpTestData();
	                 
	               
	               List<Object[]>  dataToReturn = new ArrayList<Object[]>();
	               
	              for(SignUpRequest signUp: signUpData) {
	            	  dataToReturn.add(new Object[] { signUp });
	              }
	                 
	                 return dataToReturn.iterator();
	               
	                
	                 
		    
		 
		 
		 
	 }
	 

}
