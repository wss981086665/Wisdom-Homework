package com.example.demo.service;

import com.example.demo.bean.DemoB;
import com.example.demo.bean.DemoClass;
import com.example.demo.dao.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassService {

    @Autowired
    ClassMapper classMapper;

    public List<DemoClass> getClass(String openid){
        List<DemoClass> democlass = classMapper.getClassByOpenid(openid);
        return democlass;
    }

    public List<DemoB> getClassInfo(String openid){
        List<DemoB> democlass = classMapper.getSomething(openid);
        return democlass;
    }

    public List<DemoClass> getReplyByClassid(String classid){
        List<DemoClass> democlass = classMapper.getClassByClassid(classid);
        return democlass;
    }

    public void insert(DemoClass demoClass){
        classMapper.insertClass(demoClass);
    }

    public void deleteClass(Integer id){
        classMapper.deleteClassById(id);
    }

}
