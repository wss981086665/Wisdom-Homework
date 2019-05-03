package com.example.demo.service;

import com.example.demo.bean.Forumuser;
import com.example.demo.dao.ForumuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumuserService {

    @Autowired
    ForumuserMapper forumuserMapper;

    public List<Forumuser> getForumuser(String openid){
        List<Forumuser> forumuser = forumuserMapper.getForumuser(openid);
        return forumuser;
    }

    public void insert(Forumuser forumuser){
        forumuserMapper.insertForumuser(forumuser);
    }

    public void update(String con2,String con1){
        forumuserMapper.updateForumuser(con2,con1);
    }

}
