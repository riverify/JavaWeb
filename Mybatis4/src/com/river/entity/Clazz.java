package com.river.entity;

import java.io.Serializable;
import java.util.List;

public class Clazz implements Serializable {
    private Integer clazzno;
    private String cname;

    private List<Student> std;  // 一对多

    public Clazz() {
    }

    public Clazz(Integer clazzno, String cname) {
        this.clazzno = clazzno;
        this.cname = cname;
    }

    public Integer getClazzno() {
        return clazzno;
    }

    public void setClazzno(Integer clazzno) {
        this.clazzno = clazzno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStd() {
        return std;
    }

    public void setStd(List<Student> std) {
        this.std = std;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "clazzno=" + clazzno +
                ", cname='" + cname + '\'' +
                ", std=" + std +
                '}';
    }
}
