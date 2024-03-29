package com.example.demo.bean;

public class DemoClass {

    private Integer id;
    private String classname;
    private String classid;
    private String date;        //创建日期
    private String openid;      //教师openid

    private String con1;
    private String con2;
    private String con3;
    private String con4;
    private String con5;

    @Override
    public String toString() {
        return "DemoClass{" +
                "id=" + id +
                ", classname='" + classname + '\'' +
                ", classid='" + classid + '\'' +
                ", date='" + date + '\'' +
                ", openid='" + openid + '\'' +
                ", con1='" + con1 + '\'' +
                ", con2='" + con2 + '\'' +
                ", con3='" + con3 + '\'' +
                ", con4='" + con4 + '\'' +
                ", con5='" + con5 + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCon1() {
        return con1;
    }

    public void setCon1(String con1) {
        this.con1 = con1;
    }

    public String getCon2() {
        return con2;
    }

    public void setCon2(String con2) {
        this.con2 = con2;
    }

    public String getCon3() {
        return con3;
    }

    public void setCon3(String con3) {
        this.con3 = con3;
    }

    public String getCon4() {
        return con4;
    }

    public void setCon4(String con4) {
        this.con4 = con4;
    }

    public String getCon5() {
        return con5;
    }

    public void setCon5(String con5) {
        this.con5 = con5;
    }
}
