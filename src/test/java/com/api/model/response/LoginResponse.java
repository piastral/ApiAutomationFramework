package com.api.model.response;

public class LoginResponse {

	private String timestamp;
	@Override
	public String toString() {
		return "LoginResponse [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", path=" + path + ", solution=" + solution + ", errorcode=" + errorcode + "]";
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public LoginResponse(String timestamp, int status, String error, String message, String path, String solution,
			String errorcode) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.solution = solution;
		this.errorcode = errorcode;
	}
	private int status;
	private String  error ;
	private String message;
	private String path;
	private String solution;
	private String errorcode;
	public String getToken() {
		// TODO Auto-generated method stub
		return null;
	}
}
