package com.in29minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
// we want to / hello-world  and it return "Hello world"
//REST API
@RestController
public class HelloWorldController {
	
	//@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	//creating  a simple rest api
	//here we created a method for helloWorldBean and we are returning instance of HellowordBean class
	//we created our own class HellowordBean with the member variable message and setting it value as "Hello World" 
	//when you run the code on browser you will get json response in the form of message
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world");
	}
	
	//---what is path parameter and why imp?-------    /user/{id}/todos/{id} => /user/1/todo/101    ----specific todo url for aceess
	// here 1 and 101 are variables are called path parameters
	// what we want to do ----/hello-world/path-variable/{name}
	// if someone sending name in url as variable that will be catch by @PathVariable and mapped by spring mvc in @PathVariabl.
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {	
		return new HelloWorldBean(String.format("Hello World, %s", name)
	  );
	}	
	

}
