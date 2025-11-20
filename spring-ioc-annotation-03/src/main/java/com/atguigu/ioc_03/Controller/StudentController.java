package com.atguigu.ioc_03.Controller;

import com.atguigu.ioc_03.Service.Service;
import com.atguigu.ioc_03.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private Service studentService;

    public void findAll(){
        List<Student> studentList = studentService.findAll();
        System.out.println("studentList = " + studentList);
    }
}
