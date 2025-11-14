package com.atguigu.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.controller.StudentController;
import com.atguigu.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {




    public void testDML(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql:///studb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

    }

    /*
    * 使用jdbcTemplate进行DML动作
    * */
    @Test
    public void testForIoC(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

//        TODO 执行插入一条学员数据
        String sql = "insert into students(id,name,gender,age,class) values(?,?,?,?,?);";
        /*
        参数一：sql语句
        参数二：可变参数，占位符的值
        * */
        int rows = jdbcTemplate.update(sql, 9, "十一", "男", 18, "三年二班");

        System.out.println("row = " + rows);
    }


    /*
    * 查询单条实体对象
    * */
    @Test
    public void testDQLForPojo(){
        String sql = "select id ,name, age, gender, class as classes from students where id = ?;";
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        //根据id查询
        Student student = jdbcTemplate.queryForObject(sql,  (rs, rowNum) -> {
            //自己处理结果映射
            Student stu = new Student();
            stu.setId(rs.getInt("id"));
            stu.setName(rs.getString("name"));
            stu.setAge(rs.getInt("age"));
            stu.setGender(rs.getString("gender"));
            stu.setClasses(rs.getString("classes"));
            return stu;
        }, 9);

        System.out.println("student = " + student);
    }

    /*
    * 查询实体类集合
    * */
    @Test
    public void testDQLForListPojo(){
        String sql = "select id, name, age, gender, class as classes from students;";
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        /*
        * query可以返回集合！
        * BeanPropertyRowNapper就是封装好RowMapper的实现，要求属性名和列名相同即可
        * */
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        for(Student student : studentList){
            System.out.println(student);
        }
    }

    @Test
    public void testRun(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-02.xml");

        StudentController studentController = applicationContext.getBean(StudentController.class);

        studentController.findAll();

        applicationContext.close();
    }
}
