package com.in29minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in29minutes.springboot.learnjpaandhibernate.course.jdbc.books.Books;

public interface CourseSpringDataJpaRepository extends JpaRepository<Books, Long> {

	List<Books> findByAuthor(String author);
}
