package com.example.demo.controller;

import com.example.demo.bean.DemoA;
import com.example.demo.bean.DemoC;
import com.example.demo.bean.Homework;
import com.example.demo.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    HomeworkService homeworkService;

    @RequestMapping(value = "/gethomework",method = RequestMethod.GET)
    public Map<String,Object> getHomework(DemoA demoA){
        Map<String,Object> workmap = new HashMap<String,Object>();
        List<Homework> homework = homeworkService.getHomework(demoA);
        workmap.put("homeworks",homework);
        return workmap;
    }

    @RequestMapping(value = "/getclassshomework",method = RequestMethod.GET)
    public Map<String,Object> getClassHomework(DemoC demoC){
        Map<String,Object> workmap = new HashMap<String,Object>();
        List<Homework> homework = homeworkService.getClassHomework(demoC);
        workmap.put("homeworks",homework);
        return workmap;
    }

    @RequestMapping(value = "/gethomeworkbycode",method = RequestMethod.GET)
    public Map<String,Object> getHomeworkByCode(@RequestParam(value="code",defaultValue = "null") String code){
        Map<String,Object> workmap = new HashMap<String,Object>();
        List<Homework> homework = homeworkService.getHomeworkByCode(code);
        workmap.put("homeworks",homework);
        return workmap;
    }

    @RequestMapping(value = "/inserthomework",method = RequestMethod.POST)
    public void insertHomework(Homework homework){
        String topic = homework.getTopic();
        String content = homework.getContent();
        String author = homework.getAuthor();
        String nickName = homework.getNickName();
        try {
            topic = URLDecoder.decode(topic, "UTF-8");
            homework.setTopic(topic);
            content = URLDecoder.decode(content, "UTF-8");
            homework.setContent(content);
            author = URLDecoder.decode(author, "UTF-8");
            homework.setAuthor(author);
            nickName = URLDecoder.decode(nickName, "UTF-8");
            homework.setNickName(nickName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        homeworkService.insert(homework);
    }

    @RequestMapping(value = "/deletehomeworkbyid",method = RequestMethod.GET)
    public void deleteHomework(@RequestParam(value="id") Integer id){
        homeworkService.deleteHomework(id);
    }
    
}
