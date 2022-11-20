package com.river.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

    private Integer eid;

    private String ename;

    private String pwd;

    private String sex;

    private String hobby;

    private Date birth;

    private String phone;

    private String remark;

    public Employee() {
    }

    public Employee(Integer eid, String ename, String pwd, String sex, String hobby, Date birth, String phone, String remark) {
        this.eid = eid;
        this.ename = ename;
        this.pwd = pwd;
        this.sex = sex;
        this.hobby = hobby;
        this.birth = birth;
        this.phone = phone;
        this.remark = remark;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
