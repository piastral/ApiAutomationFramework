package com.api.dataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.model.request.LoginRequest;
import com.api.utility.JsonReaderUtility;
import com.google.gson.Gson;
;

public class LoginDataProvider {
	
	@DataProvider(name="LoginTestDataProvider")
	 public static  Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		
		 
		
		     List<LoginRequest> loginTestData= JsonReaderUtility.readLoginTestData();
	                 
	               
	               List<Object[]>  dataToReturn = new ArrayList<Object[]>();
	               
	              for(LoginRequest loginRequest: loginTestData) {
	            	  dataToReturn.add(new Object[] { loginRequest });
	              }
	                 
	                 return dataToReturn.iterator();
	               
	                
	                 
		    
		 
		 
		 
	 }
	 

}
