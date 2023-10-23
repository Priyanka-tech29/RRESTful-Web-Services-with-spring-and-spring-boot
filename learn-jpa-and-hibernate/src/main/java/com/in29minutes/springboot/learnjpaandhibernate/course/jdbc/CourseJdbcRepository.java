package com.in29minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in29minutes.springboot.learnjpaandhibernate.course.jdbc.books.Books;
//here we are inserting data using Spring JDBC.
//using @Repository which is used to talk to the database
//now we have to write the query for that we need to use .update method and provide query in variable INSERT_QUERY LIKE.
//AND NOW we want to execute query at the startup of application for that we need to create new class CourseJdbcCommandLineRunner
@Repository 
public class CourseJdbcRepository {
	
//	@Autowired
//	JdbcTemplate springJdbcTemplate;
//	private static String INSERT_QUERY =
//			
//			"""
//			 insert into course (id, name, author)  values(1, 'LearnSpringBoot', 'Priyanka-tech29');
//			 
//			""";
//	public void insert() {
//		springJdbcTemplate.update(INSERT_QUERY);
//	}
	
	
//----------using class books we can insert the value what values have books class----------------------------------
	@Autowired
	JdbcTemplate springJdbcTemplate;
	private static String INSERT_QUERY =
			
			"""
			 insert into course (id, name, author)  values(?,?,?);
			 
			""";
	public void insert(Books book) {
		springJdbcTemplate.update(INSERT_QUERY , book.getId(), book.getName(), book.getAuthor());
	}
	
//------------------------------Delete records from book-------------------------------
	private static String DELETE_QUERY =
			
			"""
			 delete from course where id =?; 
			 
			""";
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY ,id);
	}
//---------------------------------Select records from course------------------------	
private static String SELECT_QUERY =
			
			"""
			select * from course 
			where id = ?; 
			 
			""";
	public Books findById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Books.class), id);
		//help us to map into bean are called Row Mapper
	}
	
	
	
	
	
}
