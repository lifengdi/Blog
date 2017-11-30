package com.lifengdi.blog.bean;

public class SysArgumentsKey {
    private Integer id;

    private String argKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArgKey() {
        return argKey;
    }

    public void setArgKey(String argKey) {
        this.argKey = argKey == null ? null : argKey.trim();
    }
}