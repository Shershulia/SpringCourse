package com.ntnu.ivansh.learnjpaandhibernate.course;

import com.ntnu.ivansh.learnjpaandhibernate.course.jdbs.CourseJdbcRepository;
import com.ntnu.ivansh.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.ntnu.ivansh.learnjpaandhibernate.course.springdatajpa.SpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    @Autowired
    private SpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"learn something","ivansh"));
        repository.save(new Course(2,"learn nothing","ivansh"));
        repository.deleteById(1);
        System.out.println(repository.findById(2));
        System.out.println(repository.findByAuthor("ivansh"));
        System.out.println(repository.findByAuthor(""));


    }
}
