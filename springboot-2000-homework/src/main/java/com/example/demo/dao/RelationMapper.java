package com.example.demo.dao;

import com.example.demo.bean.Relation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "relationMapper")
public interface RelationMapper {

    @Select("SELECT * FROM relation WHERE openid=#{openid}")
    public List<Relation> getRelationByOpenid(String openid);

    @Select("SELECT * FROM relation WHERE classid=#{classid}")
    public List<Relation> getRelationByClassid(String classid);

    @Select("SELECT truename FROM relation WHERE classid=#{classid}")
    public List<String> getStudentByClassid(String classid);

    @Select("SELECT * FROM relation WHERE topenid=#{topenid}")
    public List<Relation> getRelationByTopenid(String topenid);

    @Insert("INSERT INTO relation(openid,truename,classid,topenid,tavatarUrl,con1,con2,con3,con4,con5) VALUES(#{openid},#{truename},#{classid},#{topenid},#{tavatarUrl},#{con1},#{con2},#{con3},#{con4},#{con5})")
    public void insertRelation(Relation relation);

    @Delete("DELETE FROM relation WHERE id=#{id}")
    public void deleteRelationById(Integer id);

}
