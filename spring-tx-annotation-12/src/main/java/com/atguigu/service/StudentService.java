package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
* 通常是通过类添加注解添加事务。类下的所有方法都有事务，查询方法通过再次添加注解来设置为只读模式
*
* timeout设置事务超时时间,单位秒! 默认: -1 永不超时,不限制事务时间!
* rollbackFor = 指定哪些异常才会回滚,默认是 RuntimeException and Error 异常方可回滚!
* noRollbackFor = 指定哪些异常不会回滚, 默认没有指定,如果指定,应该在rollbackFor的范围内!
*  */
@Transactional
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Transactional(readOnly = false,
            rollbackFor = Exception.class,
            isolation = Isolation.READ_COMMITTED)
    public void changeInfo() throws FileNotFoundException {
        studentDao.updateAgeById(88,1);
//        int i =1/0;
        new FileInputStream("xxxxx");
        System.out.println("-----------");
        studentDao.updateNameById("test2",1);
    }

    /**
     * 声明两个独立修改数据库的事务业务方法
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeAge(){
        studentDao.updateAgeById(99,1);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName(){
        studentDao.updateNameById("test2",1);
//        int i = 1/0;
    }

    @Transactional(readOnly = true)
    public void getStudentInfo(){
        //查询，只读模式
    }
}