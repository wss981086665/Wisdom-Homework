package com.example.demo.service;

import com.example.demo.bean.Teacher;
import com.example.demo.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    public void insert(Teacher teacher){
        teacherMapper.insertTeacher(teacher);
    }

}
