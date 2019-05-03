package com.example.demo.service;

import com.example.demo.bean.Reply;
import com.example.demo.dao.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    public List<Reply> getReply(String openid){
        List<Reply> reply = replyMapper.getReplyByCodeid(openid);
        return reply;
    }

    public List<Reply> getReplyByCode(String code){
        List<Reply> reply = replyMapper.getReplyByCode(code);
        return reply;
    }

    public List<Reply> getReplyByCodeid(String codeid){
        List<Reply> reply = replyMapper.getReplyByCodeid(codeid);
        return reply;
    }

    public void insert(Reply reply){
        replyMapper.insertReply(reply);
    }

    public void deleteReply(Integer id){
        replyMapper.deleteReplyById(id);
    }

}
