package com.example.demo.controller;

import com.example.demo.bean.Relation;
import com.example.demo.service.ClassService;
import com.example.demo.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/relation")
public class RelationController {

    @Autowired
    RelationService relationService;

    @RequestMapping(value = "/getrelationbyopenid",method = RequestMethod.GET)
    public Map<String,Object> getReplyByOpenid(@RequestParam(value="openid",defaultValue = "null") String openid){
        Map<String,Object> relationmap = new HashMap<String,Object>();
        relationmap.put("relations",relationService.getRelationByOpenid(openid));
        return relationmap;
    }

    @RequestMapping(value = "/getrelationbyclassid",method = RequestMethod.GET)
    public Map<String,Object> getRelationByClassid(@RequestParam(value="classid",defaultValue = "null") String classid){
        Map<String,Object> relationmap = new HashMap<String,Object>();
        relationmap.put("relations",relationService.getRelationByClassid(classid));
        return relationmap;
    }
    @RequestMapping(value = "/getstudentbyclassid",method = RequestMethod.GET)
    public Map<String,Object> getStudentByClassid(@RequestParam(value="classid",defaultValue = "null") String classid){
        Map<String,Object> studentmap = new HashMap<String,Object>();
        studentmap.put("students",relationService.getStudentByClassid(classid));
        return studentmap;
    }


    @RequestMapping(value = "/getrelationbytopenid",method = RequestMethod.GET)
    public Map<String,Object> getRelationByTopenid(@RequestParam(value="topenid",defaultValue = "null") String topenid){
        Map<String,Object> relationmap = new HashMap<String,Object>();
        relationmap.put("replys",relationService.getRelationByTopenid(topenid));
        return relationmap;
    }

    @RequestMapping(value = "/insertrelation",method = RequestMethod.POST)
    public void insertRelation(Relation relation){
        relationService.insertRelation(relation);
    }

    @RequestMapping(value = "/deleterelaion",method = RequestMethod.GET)
    public void deleteRelation(@RequestParam(value="id") Integer id){
        relationService.deleteRelation(id);
    }

}
