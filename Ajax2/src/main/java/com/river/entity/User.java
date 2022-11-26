package com.river.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * FileName User
 * Date 2022/11/26 10:10
 * Author river
 */
public class User implements Serializable {
    private Integer uid;
    private String uname;
    private String pwd;

    public User() {
    }

    public User(Integer uid, String uname, String pwd) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) && Objects.equals(uname, user.uname) && Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, pwd);
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "uid:" + uid +
//                ", uname:'" + uname + '\'' +
//                ", pwd:'" + pwd + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
