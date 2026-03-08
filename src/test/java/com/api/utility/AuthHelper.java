package com.api.utility;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

public class AuthHelper {
	
	// Cached token (shared across all tests)
    private static String authToken;
    
    // Token expiry timestamp (in milliseconds)
    private static long tokenExpiryTime;
    
    // Token lifetime in milliseconds (15 minutes = 900,000 ms)
    private static final long TOKEN_LIFETIME = 15 * 60 * 1000;
    
    /**
     * Get authentication token (with auto-refresh)
     * 
     * This method:
     * 1. Checks if token exists and is still valid
     * 2. If expired or null → generates new token
     * 3. If valid → returns cached token (fast!)
     * 
     * @return Valid authentication token
     */
    public static String getAuthToken() {
        
        long currentTime = System.currentTimeMillis();
        
        // Check if token is expired or doesn't exist
        if (authToken == null || currentTime >= tokenExpiryTime) {
            
            System.out.println("🔄 Token expired or null. Generating new token...");
            refreshToken();
            
        } else {
            
            long remainingTime = (tokenExpiryTime - currentTime) / 1000;
            System.out.println("✅ Using cached token (valid for " + 
                remainingTime + " more seconds)");
        }
        
        return authToken;
    }
    
    /**
     * Generate fresh token by calling login API
     * 
     * This method:
     * 1. Calls AuthService.login()
     * 2. Extracts token from response
     * 3. Calculates expiry time
     * 4. Stores both in static variables
     */
    private static void refreshToken() {
        
        // Call login API
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("uday1234", "uday1234");
        
        Response response = authService.login(loginRequest);
        
        // Validate response
        if (response.statusCode() != 200) {
            throw new RuntimeException("Login failed! Status: " + 
                response.statusCode());
        }
        
        // Extract token from response
        LoginResponse loginResponse = response.as(LoginResponse.class);
        authToken = loginResponse.getToken();
        
        // Calculate expiry time (current time + token lifetime)
        tokenExpiryTime = System.currentTimeMillis() + TOKEN_LIFETIME;
        
        System.out.println("✅ New token generated: " + 
            authToken.substring(0, 20) + "...");
        System.out.println("✅ Token expires at: " + 
            new java.util.Date(tokenExpiryTime));
    }
    
    /**
     * Get token for specific user (if testing with different users)
     * 
     * @param username Username for login
     * @param password Password for login
     * @return Token for that specific user
     */
    public static String getAuthToken(String username, String password) {
        
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest(username, password);
        
        Response response = authService.login(loginRequest);
        
        if (response.statusCode() != 200) {
            throw new RuntimeException("Login failed for user: " + username);
        }
        
        LoginResponse loginResponse = response.as(LoginResponse.class);
        return loginResponse.getToken();
    }
    
    /**
     * Manually invalidate cached token (for logout scenarios)
     */
    public static void invalidateToken() {
        authToken = null;
        tokenExpiryTime = 0;
        System.out.println("🗑️ Token invalidated (cleared from cache)");
    }

}
