package com.api.model.request;

public class ProfileRequest {

	@Override
	public String toString() {
		return "ProfileRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + "]";
	}

	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;

	// NO-ARG CONSTRUCTOR (for Gson)
	public ProfileRequest() {
	}

	// ALL-ARG CONSTRUCTOR (if needed for manual creation)
	public ProfileRequest(String firstName, String lastName, String email, String mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	// Getters and Setters (for Gson)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
