package com.bjpowernode.mybatis.dao;

import com.bjpowernode.mybatis.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student getById(String id);

    public void insert(Student student);

    Student select1(String s);

    List<Student> select2(String id);

    List<Student> select3(String name);

    List<Student> select4(Map map);

    int select5();

    Map select6(int i);

    List<Map> select7();
}
