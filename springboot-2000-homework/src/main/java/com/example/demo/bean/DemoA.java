package com.example.demo.bean;

public class DemoA {

    private String openid;
    private Integer page;

    @Override
    public String toString() {
        return "DemoA{" +
                "openid='" + openid + '\'' +
                ", page=" + page +
                '}';
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
