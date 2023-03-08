package com.ntnu.ivansh.learnjpaandhibernate.course.jdbs;

import com.ntnu.ivansh.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT = """
           INSERT INTO COURSE (id,name,author) VALUES (?,?,?)
            """;
    private static String DELETE = """
           DELETE FROM COURSE WHERE id = ?;
            """;
    private static String SELECT = """
           SELECT * FROM COURSE WHERE id = ?;
            """;

    public void insert(Course course){
        jdbcTemplate.update(INSERT,course.getId(),course.getName(),course.getAuthor());
    }
    public void delete(int id){
        jdbcTemplate.update(DELETE,id);
    }
    public Course select(int id){
        //ResultSet-> Bean=> RowMapper
        return jdbcTemplate.queryForObject(SELECT,new BeanPropertyRowMapper<>(Course.class),id);
    }
}
