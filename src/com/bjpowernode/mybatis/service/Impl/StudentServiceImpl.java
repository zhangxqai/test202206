package com.bjpowernode.mybatis.service.Impl;

import com.bjpowernode.mybatis.dao.StudentDao;
import com.bjpowernode.mybatis.domain.Student;
import com.bjpowernode.mybatis.service.StudentService;
import com.bjpowernode.mybatis.util.SqlSessionUtil;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

    @Override
    public Student getById(String id) {
        Student s = studentDao.getById(id);
        return s;
    }

    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }

}
