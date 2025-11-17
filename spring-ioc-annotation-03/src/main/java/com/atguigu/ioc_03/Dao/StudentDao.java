package com.atguigu.ioc_03.Dao;

import com.atguigu.ioc_03.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> queryAll();
}
