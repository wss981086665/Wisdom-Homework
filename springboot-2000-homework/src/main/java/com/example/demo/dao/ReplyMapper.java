package com.example.demo.dao;

import com.example.demo.bean.Reply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "replyMapper")
public interface ReplyMapper {

    @Select("SELECT * FROM reply WHERE openid=#{openid}")
    public List<Reply> getReplyByOpenid(String openid);

    @Select("SELECT * FROM reply WHERE code=#{code}")
    public List<Reply> getReplyByCode(String code);

    @Select("SELECT * FROM reply WHERE codeid=#{codeid}")
    public List<Reply> getReplyByCodeid(String codeid);

    @Insert("INSERT INTO reply(code,codeid,imgurl,openid,content,date,author,nickName,avatarUrl,factor1,factor2,factor3,factor4,factor5,factor6,factor7,factor8,factor9,factor10) VALUES(#{code},#{codeid},#{imgurl},#{openid},#{content},#{date},#{author},#{nickName},#{avatarUrl},#{factor1},#{factor2},#{factor3},#{factor4},#{factor5},#{factor6},#{factor7},#{factor8},#{factor9},#{factor10})")
    public void insertReply(Reply reply);

    @Delete("DELETE FROM reply WHERE id=#{id}")
    public void deleteReplyById(Integer id);

}
