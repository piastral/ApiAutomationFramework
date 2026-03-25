
	
	
/**
 *  * Database utility class for database validation in test 
 * 
 * 
 */


package com.api.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.api.models.database.Payment;

/**
 * Database utility class for database validation in tests
 */
public class DBUtils {
    
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/banking_db";
    private static final String DB_USER = "test_user";
    private static final String DB_PASSWORD = "test_password";
    
    private static Connection connection;
    
    /**
     * Establish database connection
     */
    public static Connection getConnection() throws SQLException {
        
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("✅ Database connection established");
        }
        
        return connection;
    }
    
    /**
     * Execute SELECT query and return ResultSet
     * 
     * @param query - SQL SELECT query
     * @return ResultSet with query results
     */
    public static ResultSet executeQuery1(String query) throws SQLException {
        
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        return resultSet;
    }
    
    /**
     * Execute UPDATE/INSERT/DELETE query
     * 
     * @param query - SQL query
     * @return Number of rows affected
     */
    public static int executeUpdate(String query) throws SQLException {
        
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        int rowsAffected = statement.executeUpdate(query);
        
        return rowsAffected;
    }
    
    /**
     * Close database connection
     */
    public static void closeConnection() {
        
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔌 Database connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Get payment details from database by payment ID
     * 
     * @param paymentId - Payment ID to search
     * @return Payment object with database data
     */
    public static Payment getPaymentById(String paymentId) throws SQLException {
        
        String query = "SELECT * FROM payments WHERE payment_id = '" + paymentId + "'";
        ResultSet rs = executeQuery1(query);
        
        Payment payment = null;
        
        if (rs.next()) {
            payment = new Payment();
            payment.setPaymentId(rs.getString("payment_id"));
            payment.setAmount(rs.getDouble("amount"));
            payment.setStatus(rs.getString("status"));
            payment.setAccountId(rs.getString("account_id"));
            payment.setCreatedAt(rs.getTimestamp("created_at"));
        }
        
        return payment;
    }
    
    /**
     * Wait for database record to appear (for async operations)
     * 
     * @param paymentId - Payment ID to wait for
     * @param maxWaitSeconds - Maximum time to wait
     * @return Payment object or null if not found
     */
    public static Payment waitForPayment(String paymentId, int maxWaitSeconds) 
            throws SQLException, InterruptedException {
        
        int attempts = 0;
        int maxAttempts = maxWaitSeconds;
        Payment payment = null;
        
        while (attempts < maxAttempts) {
            
            payment = getPaymentById(paymentId);
            
            if (payment != null ) {
                System.out.println("✅ Payment found in database after " + 
                    attempts + " seconds");
                return payment;
            }
            
            System.out.println("⏳ Payment not found, waiting... (attempt " + 
                (attempts + 1) + "/" + maxAttempts + ")");
            
            Thread.sleep(1000); // Wait 1 second
            attempts++;
        }
        
        System.out.println("❌ Payment not found after " + maxWaitSeconds + " seconds");
        return null;
    }
}
