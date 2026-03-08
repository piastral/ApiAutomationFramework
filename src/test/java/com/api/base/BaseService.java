package com.api.base;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import com.api.model.request.LoginRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseService {
	/*
	 * base service will be responsible for setting up my request specification this
	 * introduces new design pattern service object model 1- will be handling
	 * baseURI 2-for creating the request 3-handling the response this is the
	 * wrapper for my rest assured this is where my abstraction comes into picture
	 * 
	 * 
	 */

	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification; 

	public BaseService() {

		requestSpecification = given().baseUri(BASE_URL);
		
	}
	 
	//ill be creating the post request /header.body,endpoint to make any request
	
	protected Response  postRequest(Object payload ,String endPoint) { 
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	

	
	protected Response putRequest(Object token ,Object payload, String endpoint) {
		return requestSpecification.header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(payload).put(endpoint);
	}

	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}

}