package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter  implements Filter{
/* what is filter why it is used in rest assured 
 * filters-> mean it intercepts if i want to modificiaton in between two position and then intercept 
 * lets say you make reuqest in rest assured it will reach to hte server ,before it reach the server i want modify something lets 
 * say i want to capture the request what is the base url ,what is the endpoint ,so that i can log this and then again ill let it continue 
 * to request for the service 
 * 
 * 
 * same also when server process the request it returns the response so before the response reaches test for further validation 
 * i want to capture using filter it will capture the response,header respoonse payload response time ,status code 
 * 
 * --> listeners --> 
 * somewhere we will m ake sure listenrs and filters communicate so that filter are able to capture based on listners response 
 * since listener everythime will help me to log when the test start when the test fails when the test skip ...
 * 	
 */
	
	
	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response=ctx.next(requestSpec, responseSpec);//Request is going to executed
		logResponse(response);
		
		return response;//test for assertion
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI:"+ requestSpec.getBaseUri());
		logger.info("Request Header:"+ requestSpec.getHeaders());
		logger.info("Request PayLoad:"+ requestSpec.getBody());



	}
	
	public void logResponse(Response response) {
		logger.info("STATUS CODE:"+ response.getStatusCode());
		logger.info("Response Header :"+ response.headers());
		logger.info("Request Body:"+ response.getBody().prettyPrint());
	}


}
