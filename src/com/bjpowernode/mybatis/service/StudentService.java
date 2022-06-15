package com.bjpowernode.mybatis.service;

import com.bjpowernode.mybatis.domain.Student;

public interface StudentService {

    public Student getById(String id);

    public void insert(Student student);

}
