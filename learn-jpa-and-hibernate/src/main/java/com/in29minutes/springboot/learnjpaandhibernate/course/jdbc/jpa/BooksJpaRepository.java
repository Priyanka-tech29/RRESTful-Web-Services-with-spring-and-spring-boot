package com.in29minutes.springboot.learnjpaandhibernate.course.jdbc.jpa;

import org.springframework.stereotype.Repository;

import com.in29minutes.springboot.learnjpaandhibernate.course.jdbc.books.Books;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class BooksJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	//insert data when we are using spring jpa
	
	public void insert(Books book) {
		
		entityManager.merge(book);
		
	}
	
	//find  by ID
    public Books findById(long id) {
		
		return entityManager.find(Books.class,id);
		
	}
    
    //delete by id
    public void deleteById(long id) {
		
	      Books book =  entityManager.find(Books.class,id);
	      entityManager.remove(book);
		
	}
    //afetr that go to the JDBCcommandrunner class and make it commandrunner class 
    //chage it with Jpa if we are using jpa 
	
}
