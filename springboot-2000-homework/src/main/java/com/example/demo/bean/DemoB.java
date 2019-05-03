package com.example.demo.bean;

public class DemoB {

    private String classname;
    private String classid;

    @Override
    public String toString() {
        return "DemoB{" +
                "classname='" + classname + '\'' +
                ", classid='" + classid + '\'' +
                '}';
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
}
