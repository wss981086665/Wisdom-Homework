package com.example.demo.controller;

import com.example.demo.bean.Forumuser;
import com.example.demo.service.ForumuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

@RestController
@RequestMapping("operateuser")
public class ForumuserController {

    @Autowired
    ForumuserService forumuserService;

    @RequestMapping(value = "/getforumuser",method = RequestMethod.GET)
    public Map<String,Object> getForumuser(@RequestParam(value="openid",defaultValue = "null") String openid){

        Map<String,Object> forumusers= new HashMap<String,Object>();
        List<Forumuser> forumuser = forumuserService.getForumuser(openid);
        String num = String.valueOf(forumuser.size());
        forumusers.put("forumusers",forumuser);
        forumusers.put("forumusernum",num);
        return forumusers;
    }

    @RequestMapping(value = "/inserforumuser",method = RequestMethod.GET)
    public Map<String,Object> insertForumuser(Forumuser forumuser){
        String test = getForumuser(forumuser.getOpenid())
                .get("forumusernum")
                .toString();

        String userid = String.valueOf((int)((Math.random()*9+1)*10000000));
        Map<String,Object> useridMap= new HashMap<String,Object>();

//        /********************************************管理员*/
//        Boolean hasadministor = false;
//        List<String> administor = new LinkedList<String>();
////        administor.add("oyUd75XZF0bBq3vCkSfo4an7hxNs");
//        Iterator<String> itor = administor.iterator();
//        while (itor.hasNext()){
//            if(itor.next().equals(forumuser.getOpenid())) hasadministor = true;
//        }
//        useridMap.put("hasadministor",hasadministor);

        if(test.equals("0")){
            forumuser.setCon1(userid);
            String nickName = forumuser.getNickName();
            String name = forumuser.getCon2();
            try {
                nickName = URLDecoder.decode(nickName, "UTF-8");
                forumuser.setNickName(nickName);
                name = URLDecoder.decode(name, "UTF-8");
                forumuser.setCon2(name);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            forumuserService.insert(forumuser);
            useridMap.put("userid",userid);
            useridMap.put("name",name);
        }else {
            userid = forumuserService
                    .getForumuser(forumuser.getOpenid())
                    .get(0)
                    .getCon1();
            String username = forumuserService
                    .getForumuser(forumuser.getOpenid())
                    .get(0)
                    .getCon2();
            useridMap.put("userid",userid);
            useridMap.put("name",username);
        }
        return useridMap;
    }

    @RequestMapping(value = "/getuserid",method = RequestMethod.GET)
    public String getUserId(String openid){
        String userid = forumuserService
                .getForumuser(openid)
                .get(0)
                .getCon1();
        return userid;
    }

    @RequestMapping(value = "/judgeteacher",method = RequestMethod.GET)
    public String judgeTeacher(String openid){
        String userid = forumuserService
                .getForumuser(openid)
                .get(0)
                .getCon2();
        return userid;
    }

    @RequestMapping(value = "/updateorumuser",method = RequestMethod.GET)
    public void updateForumuser(String con2,String con1){
        forumuserService.update(con2,con1);
    }
}
