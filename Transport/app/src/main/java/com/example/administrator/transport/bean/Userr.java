package com.example.administrator.transport.bean;

import cn.bmob.v3.BmobObject;

public class Userr extends BmobObject {
    private String Ctype;
    private String Gtype;
    private String Birthland;
    private String Destination;

    public String getCtype() {
        return Ctype;
    }
    public void setCtype(String Ctype) {
        this.Ctype = Ctype;
    }

    public String getGtype() {
        return Gtype;
    }
    public void setGtype(String Gtype) {
        this.Gtype = Gtype;
    }

    public String getBirthland() {
        return Birthland;
    }
    public void setBirthland(String Birthland) {
        this.Birthland = Birthland;
    }

    public String getDestination() {
        return Destination;
    }
    public void setDestination(String Destination) {
        this.Destination = Destination;
    }


}