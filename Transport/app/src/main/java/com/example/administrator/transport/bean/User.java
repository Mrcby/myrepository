package com.example.administrator.transport.bean;


import cn.bmob.v3.BmobObject;

public class User extends BmobObject{
    String username;
    String userpwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

}
