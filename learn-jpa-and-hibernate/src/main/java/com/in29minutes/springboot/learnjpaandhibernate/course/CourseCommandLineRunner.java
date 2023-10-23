package com.in29minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//we want to fire up insert query for that we need to use Autowired CourseJdbcRepository
//use @component so our spring framework can find it in component scan
//using insert method which is calling query
//and go and autowired CourseJdbcRepository as well
//and now run your application and /localhost:8080/h2-console and see table data  have been inserted.

import com.in29minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in29minutes.springboot.learnjpaandhibernate.course.jdbc.books.Books;
import com.in29minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in29minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
	
		
		
//***************************************Using Spring JDBC and JPA********************************
		
//----------------using class books we can insert the value what values have books class
		
//now if you want to insert multiple books details
//after that save all and run application and see all details
		
//	 repository.insert( new Books(1,"Learn AWS jpa","priyanka-tech29"));
//	 repository.insert( new Books(2,"Learn Spring boot jpa","priyanka-tech29"));
//	 repository.insert( new Books(3,"Learn Science jpa","priyanka-tech29"));
//	 repository.insert( new Books(4,"Learn Java jpa","priyanka-tech29"));
 
//------------------------------Delete records from book-------------------------------
	 
//	 repository.deleteById(1);
		
//-----------------------------------find record by id------------------------------------
//	 System.out.println(repository.findById(4));
//	 System.out.println(repository.findById(3));
//	 
	 
		
//	 **********************************using Spring data jpa********************************
		
		//after that save all and run application and see all details
	 repository.save( new Books(1,"Learn AWS jpa","priyanka-tech29"));
	 repository.save( new Books(2,"Learn Spring boot jpa","priyanka-tech29"));
	 repository.save( new Books(3,"Learn Science jpa","priyanka-tech29"));
	 repository.save( new Books(4,"Learn Java jpa","priyanka-tech29"));
	 
     repository.deleteById(1l); //add 'L' because we are using long
	 
	 System.out.println(repository.findById(4l));
	 System.out.println(repository.findById(3l));
	 System.out.println(repository.findByAuthor("priyanka-tech29"));
	 
	// repository.findAll(); you can use multiple methods just extend jpa repo and use them no need of entitymanagers
	 repository.findAll();
					
	}

}
