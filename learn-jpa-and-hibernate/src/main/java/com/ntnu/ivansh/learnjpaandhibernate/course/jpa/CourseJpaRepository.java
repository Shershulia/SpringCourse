package com.ntnu.ivansh.learnjpaandhibernate.course.jpa;

import com.ntnu.ivansh.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext //like autowired but for entitymanager
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }
    public Course find(int id){
        return entityManager.find(Course.class,id);
    }
    public void delete(int id){
        entityManager.remove(find(id));
    }


}
