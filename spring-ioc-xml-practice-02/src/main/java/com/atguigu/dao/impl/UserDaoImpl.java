package com.atguigu.dao.impl;

import com.atguigu.dao.StudentDao;
import com.atguigu.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements StudentDao {
//    写成一个全局变量
    private JdbcTemplate jdbcTemplate;

//    注入jdbcTmplate对象
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll(){
//        jdbcTemplate进行数据库的查询 ioc容器进行装配，不要自己去实例化

        String sql = "select id, name, age, gender, class as classes from students;";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("StudentDao:"+studentList);
        return studentList;
    }
}
