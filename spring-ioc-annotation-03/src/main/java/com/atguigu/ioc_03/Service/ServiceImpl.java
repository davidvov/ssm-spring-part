package com.atguigu.ioc_03.Service;

import com.atguigu.ioc_03.Dao.StudentDao;
import com.atguigu.ioc_03.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements com.atguigu.ioc_03.Service.Service {
    @Autowired
    private StudentDao studentDao;
    public List<Student> findAll(){
        List<Student> studentList = studentDao.queryAll();

        return studentList;
    }
}
