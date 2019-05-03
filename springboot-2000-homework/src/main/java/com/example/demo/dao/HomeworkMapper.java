package com.example.demo.dao;

import com.example.demo.bean.DemoA;
import com.example.demo.bean.DemoC;
import com.example.demo.bean.Forumuser;
import com.example.demo.bean.Homework;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "homeworkMapper")
public interface HomeworkMapper {

    @Select("SELECT * FROM homework WHERE openid=#{openid} order by date desc limit #{page},10")
    public List<Homework> getWorkByOpenid(DemoA demoA);

    @Select("SELECT * FROM homework WHERE factor1=#{classid} order by date desc limit #{page},10")
    public List<Homework> getClassWork(DemoC demoC);

    @Select("SELECT * FROM homework WHERE code=#{code}")
    public List<Homework> getWorkByCOde(String code);

    @Insert("INSERT INTO homework(code,imgurl,openid,topic,content,date,author,nickName,avatarUrl,factor1,factor2,factor3,factor4,factor5,factor6,factor7,factor8,factor9,factor10) VALUES(#{code},#{imgurl},#{openid},#{topic},#{content},#{date},#{author},#{nickName},#{avatarUrl},#{factor1},#{factor2},#{factor3},#{factor4},#{factor5},#{factor6},#{factor7},#{factor8},#{factor9},#{factor10})")
    public void insertWork(Homework homework);

    @Delete("DELETE FROM homework WHERE id=#{id}")
    public void deleteHomeworkById(Integer id);

}
