//1) In this course we will discuss about implementation of GET methods to retrieve the details of all user and a specific user.
//2) implement a RESTapi to create, insert and add a specific user using POST method ----example -POST/users
package com.in29minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

//this is a rest API
@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	// retrieve all details from user
	// GET/users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {

		return service.findAll();
	}

	// retrieve specific user details from user list
	// GET /users

//	@GetMapping("/users/{id}")
//	public User retrieveUser(@PathVariable int id) {
//	
//	return service.findOne(id);
//			
//	}

// <-------------------------------Implementing Exception Handling 404 resources---------------------->	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {

		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id:" + id);
		return user;
	}

	// create a new user
	// POST /users
	// in the bodyRequest we have all user details which is mapped into userBean and
	// once we recived the user details then we want to
	// create the user go to in UserDaoService crate a save method
	// you can not execute post request directly from the browser for that you have
	// to be go for RESTApi client to be able to fire post request
	// example - TalentAPI tester download it and add your chrome browser and lunch
	// it
	// after the lunch get url and check it with specific method then you will get
	// reponse of each url

	// ----------------------------------------------------------------------------------------------------

	// example GET -http://localhost:8080/users/4
	// Response - {id : 4 , name: "Sneha", birthDate: "2005-10-01" }
	// copy the body and select post method send url without specific id ex-
	// http://localhost:8080/users
	// which exactly match your post method url @PostMapping("/users")
	// inside the body paste content of user which you want to create
	// you don't need to pass the id , you can remove it and after that send url and
	// you will get response 200.
	// then is in browser of your new user which one you creATED EX-
	// http://localhost:8080/users
	// So here we created RestApi to add new user successfully.

//	@PostMapping("/users")
//	public void createUser(@RequestBody User user) {
//		service.save(user);
//		
//	}

//	<-------------------------------Enhancing POST METHOD to return correct HTTP STATUS of RestApi-------------------------------->
	// 201- use for created
	// change the return type
	// once user is created we are returning back status 201
	// also url return --/users/4 ---use specific location header
	// /users/4 => /users /{id} , user.getID()
	// here we want to add a path /{id} -> /5 and we want to replace this variable
	// id with id of the created user and after that we want
	// to convert into a uri and return it back ---location
	// save and check in browser and go talent api tester send one new post request
	// then you will be able to see loc in response as well
	// http://localhost:8080/users/5
	//Implement validation for restapi using @Valid and open User class using ctrl+mouse courser(Implementation & Declaration)

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

//-------------------------- Implementing DELETE method to delete a User resource----------------------------------------------

	// go to userDaoService create or iml A method for delete
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {

		service.deleteById(id);

	}

}
