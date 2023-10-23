package com.in29minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	// UserDaoService > Static List

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;

	static {

		users.add(new User(1, "Priyansi ", LocalDate.now().minusYears(30)));// we are creating a Priyansi Shani who is
																			// 30 yrs old
		users.add(new User(++usersCount, "Shani", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Divya", LocalDate.now().minusYears(23)));
		users.add(new User(++usersCount, "Kashis", LocalDate.now().minusYears(44)));
		users.add(new User(++usersCount, "Sneha", LocalDate.now().minusYears(18)));
	}

//------------------------------retrieve all user resource-------------------------------------

	public List<User> findAll() {
		return users;
	}

//---------------------------------find specific user resource----------------------------------	

	// use functional Programming to get users details
	// from the list we want to filter based on the id
	// we want to check if user id is equal to getId then we want print it's
	// predicate by using lambda
	// here we are doing taking a list converting it into stream and filtering based
	// on predicate and predicate is basically check if the
	// id is matches whatever id is passed inside findOne() method.

	public User findOne(int id) {

		Predicate<? super User> predicate = users -> users.getId().equals(id);
		// return users.stream().filter(predicate).findFirst().get();
		return users.stream().filter(predicate).findFirst().orElse(null); // 404 error
	}

//--------------------------------save or create user resources----------------------------------------

	// save method for create a new user and save it
	// whenever we create a new user we will want to assign dynamically a id to her
	// for that we have count variable create it.
	// now we have save method go inside Controller class and call it for action
	public User save(User user) {

		user.setId(++usersCount); // it's kind of temporary information
		users.add(user);
		return user;
	}

//-------------------------------Delete user resources-------------------------------------------------

	// if id is matches we are going to remove the resources
	public void deleteById(int id) {

		Predicate<? super User> predicate = users -> users.getId().equals(id);
		users.removeIf(predicate);

	}

}
