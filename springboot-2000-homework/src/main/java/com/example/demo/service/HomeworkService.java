package com.example.demo.service;

import com.example.demo.bean.DemoA;
import com.example.demo.bean.DemoC;
import com.example.demo.bean.Forumuser;
import com.example.demo.bean.Homework;
import com.example.demo.dao.HomeworkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkService {

    @Autowired
    HomeworkMapper homeworkMapper;

    public List<Homework> getHomework(DemoA demoA){
        List<Homework> homework = homeworkMapper.getWorkByOpenid(demoA);
        return homework;
    }

    public List<Homework> getClassHomework(DemoC demoC){
        List<Homework> homework = homeworkMapper.getClassWork(demoC);
        return homework;
    }

    public List<Homework> getHomeworkByCode(String code){
        List<Homework> homework = homeworkMapper.getWorkByCOde(code);
        return homework;
    }

    public void insert(Homework homework){
        homeworkMapper.insertWork(homework);
    }

    public void deleteHomework(Integer id){
        homeworkMapper.deleteHomeworkById(id);
    }

}
