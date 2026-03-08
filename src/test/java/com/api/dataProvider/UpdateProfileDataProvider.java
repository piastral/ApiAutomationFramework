package com.api.dataProvider;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.model.request.ProfileRequest;
import com.api.utility.JsonReaderUtility;

public class UpdateProfileDataProvider {
	 @DataProvider(name = "UpdateProfileTestDataProvider")
	    public static Iterator<Object[]> updateProfileDataProvider() 
	            throws FileNotFoundException {
	        
	        // Read data from JSON
	        List<ProfileRequest> profileTestData = JsonReaderUtility.readUpdateProfileTestData();
	        
	        // Prepare for TestNG
	        List<Object[]> dataToReturn = new ArrayList<>();
	        
	        for (ProfileRequest profileRequest : profileTestData) {
	            dataToReturn.add(new Object[] { profileRequest });
	        }
	        
	        return dataToReturn.iterator();
	    }
}
