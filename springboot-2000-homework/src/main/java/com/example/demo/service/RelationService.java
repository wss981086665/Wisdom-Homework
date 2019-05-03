package com.example.demo.service;

import com.example.demo.bean.Relation;
import com.example.demo.dao.RelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Service
public class RelationService {

    @Autowired
    RelationMapper relationMapper;

    public List<Relation> getRelationByOpenid(String openid){
        List<Relation> relation = relationMapper.getRelationByOpenid(openid);
        return relation;
    }

    public List<Relation> getRelationByClassid(String classid){
        List<Relation> relation = relationMapper.getRelationByClassid(classid);
        return relation;
    }

    public List<String> getStudentByClassid(String classid){
        List<String> students = relationMapper.getStudentByClassid(classid);
        return students;
    }

    public List<Relation> getRelationByTopenid(String topenid){
        List<Relation> relation = relationMapper.getRelationByTopenid(topenid);
        return relation;
    }

    public void insertRelation(Relation relation){

        String truename = relation.getTruename();
        String classname = relation.getCon1();
        try {
            truename = URLDecoder.decode(truename, "UTF-8");
            relation.setTruename(truename);
            classname = URLDecoder.decode(classname, "UTF-8");
            relation.setCon1(classname);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(relation.getTopenid());
        relationMapper.insertRelation(relation);
    }

    public void deleteRelation(Integer id){
        relationMapper.deleteRelationById(id);
    }

}
