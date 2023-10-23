package com.in29minutes.springboot.learnjpaandhibernate.course.jpa;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in29minutes.springboot.learnjpaandhibernate.course.jdbc.books.Books;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	
	@PersistenceContext
	
	private EntityManager entityManager;
	
//	insert data in course table
	
	public void insert(Books book) {
		entityManager.merge(book);
		
	}
	
	// find by id using jpa
	
	public Books findById(long id) {
		
		return entityManager.find(Books.class, id);
	}
	
	// delete data using jpa
	
	public void deleteById(long id) {
		
		Books book = entityManager.find(Books.class,id);
		entityManager.remove(book);
		
	}
}
