package com.ssm.entity;

/**
 * Created by Administrator on 2016/12/20.
 */
public class User {
    private int id;
    private String eName;
    private String cName;
    private String telphone;
    private String email;
    private String onestoneId;
    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOnestoneId() {
        return onestoneId;
    }

    public void setOnestoneId(String onestoneId) {
        this.onestoneId = onestoneId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
