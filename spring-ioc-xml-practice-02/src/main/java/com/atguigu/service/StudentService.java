package com.atguigu.service;

import com.atguigu.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 查询全部学员数据业务
     * @return
     */
    List<Student> findAll();
}
