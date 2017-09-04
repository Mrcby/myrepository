package com.example.administrator.transport.bean;


import cn.bmob.v3.BmobObject;

public class Driver extends BmobObject{
    String drivername;
    String driverpwd;
    String success;

    public String getDrivername() {
        return drivername;
    }
    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDriverpwd() {
        return driverpwd;
    }
    public void setDriverpwd(String driverpwd) {
        this.driverpwd = driverpwd;
    }

    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
}
