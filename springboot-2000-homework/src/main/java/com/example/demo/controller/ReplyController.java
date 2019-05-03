package com.example.demo.controller;

import com.example.demo.bean.Reply;
import com.example.demo.service.ReplyService;
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
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/getreply",method = RequestMethod.GET)
    public Map<String,Object> getReply(@RequestParam(value="openid",defaultValue = "null") String openid){
        Map<String,Object> replymap = new HashMap<String,Object>();
        List<Reply> reply = replyService.getReply(openid);
        replymap.put("replys",reply);
        return replymap;
    }

    @RequestMapping(value = "/getreplybycode",method = RequestMethod.GET)
    public Map<String,Object> getReplyByCode(@RequestParam(value="code",defaultValue = "null") String code){
        Map<String,Object> replymap = new HashMap<String,Object>();
        List<Reply> reply = replyService.getReplyByCode(code);
        replymap.put("replys",reply);
        return replymap;
    }

    @RequestMapping(value = "/getreplybycodeid",method = RequestMethod.GET)
    public Map<String,Object> getReplyByCodeid(@RequestParam(value="codeid",defaultValue = "null") String codeid){
        Map<String,Object> replymap = new HashMap<String,Object>();
        List<Reply> reply = replyService.getReplyByCodeid(codeid);
        replymap.put("replys",reply);
        return replymap;
    }

    @RequestMapping(value = "/insertreply",method = RequestMethod.POST)
    public void insertReply(Reply reply){
        String content = reply.getContent();
        String author = reply.getAuthor();
        String nickName = reply.getNickName();
        try {
            content = URLDecoder.decode(content, "UTF-8");
            reply.setContent(content);
            author = URLDecoder.decode(author, "UTF-8");
            reply.setAuthor(author);
            nickName = URLDecoder.decode(nickName, "UTF-8");
            reply.setNickName(nickName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        replyService.insert(reply);
    }

    @RequestMapping(value = "/deletereply",method = RequestMethod.GET)
    public void deleteReply(@RequestParam(value="id") Integer id){
        replyService.deleteReply(id);
    }

}
