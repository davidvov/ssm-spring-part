package com.atguigu.service.impl;

import com.atguigu.dao.StudentDao;
import com.atguigu.pojo.Student;
import com.atguigu.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
//    生成全局变量，不用实例化studentDao
    private StudentDao studentDao;
    public void setStudentDao(StudentDao studentDao){
        this.studentDao =  studentDao;
    }

    @Override
    public List<Student> findAll(){
        List<Student> studentlist = studentDao.queryAll();
        System.out.println("StudentService:" + studentlist);
        return studentlist;
    }
}
