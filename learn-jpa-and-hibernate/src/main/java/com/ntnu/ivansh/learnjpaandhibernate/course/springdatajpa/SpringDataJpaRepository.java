package com.ntnu.ivansh.learnjpaandhibernate.course.springdatajpa;

import com.ntnu.ivansh.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaRepository extends JpaRepository<Course,Integer> {
    List<Course> findByAuthor(String author);
}
