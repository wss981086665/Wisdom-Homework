package com.example.demo.dao;

import com.example.demo.bean.DemoB;
import com.example.demo.bean.DemoClass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "classMapper")
public interface ClassMapper {

    @Select("SELECT * FROM democlass WHERE openid=#{openid}")
    public List<DemoClass> getClassByOpenid(String openid);

    @Select("SELECT classname,classid FROM democlass WHERE openid=#{openid}")
    public List<DemoB> getSomething(String openid);

    @Select("SELECT * FROM democlass WHERE classid=#{classid}")
    public List<DemoClass> getClassByClassid(String classid);

    @Insert("INSERT INTO democlass(classname,classid,date,openid,con1,con2,con3,con4,con5) VALUES(#{classname},#{classid},#{date},#{openid},#{con1},#{con2},#{con3},#{con4},#{con5})")
    public void insertClass(DemoClass demoClass);

    @Delete("DELETE FROM democlass WHERE id=#{id}")
    public void deleteClassById(Integer id);

}
