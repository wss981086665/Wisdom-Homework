package com.example.demo.controller;

import com.example.demo.bean.DemoB;
import com.example.demo.bean.DemoClass;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/democlass")
public class ClassController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/getclass",method = RequestMethod.GET)
    public Map<String,Object> getClassByOpenid(@RequestParam(value="openid",defaultValue = "null") String openid){
        Map<String,Object> classmap = new HashMap<String,Object>();
        List<DemoClass> classes = classService.getClass(openid);
        classmap.put("classes",classes);
        return classmap;
    }

    @RequestMapping(value = "/getclassinfo",method = RequestMethod.GET)
    public Map<String,Object> getClassInfo(@RequestParam(value="openid",defaultValue = "null") String openid){
        Map<String,Object> classmap = new HashMap<String,Object>();
        List<DemoB> classes = classService.getClassInfo(openid);

        List<String> classinfo = classes.stream()
                .map(DemoB::getClassname)
                .collect(Collectors.toList());

        classmap.put("classnames",classinfo);

        classinfo = classes.stream()
                .map(DemoB::getClassid)
                .collect(Collectors.toList());

        classmap.put("classids",classinfo);
        return classmap;
    }

    @RequestMapping(value = "/getclassbyclassid",method = RequestMethod.GET)
    public Map<String,Object> getClassByClassid(@RequestParam(value="classid",defaultValue = "null") String classid){
        Map<String,Object> classmap = new HashMap<String,Object>();
        List<DemoClass> classes = classService.getReplyByClassid(classid);
        classmap.put("classes",classes);
        return classmap;
    }

    @RequestMapping(value = "/insertclass",method = RequestMethod.POST)
    public void insertClass(DemoClass demoClass){
        String classname = demoClass.getClassname();
        try {
            classname = URLDecoder.decode(classname, "UTF-8");
            demoClass.setClassname(classname);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        classService.insert(demoClass);
    }

    @RequestMapping(value = "/deleteclass",method = RequestMethod.GET)
    public void deleteReply(@RequestParam(value="id") Integer id){
        classService.deleteClass(id);
    }

}
