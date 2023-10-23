package com.in29minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

	private String message;
	
	//constructor

	public HelloWorldBean(String message) {
		this.message=message;
	}
	
	//getters & setters

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	//to String

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	

}
