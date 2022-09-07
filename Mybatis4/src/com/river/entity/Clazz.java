package com.river.entity;

import java.io.Serializable;

public class Clazz implements Serializable {
    private Integer clazzno;
    private String cname;

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

    @Override
    public String toString() {
        return "Clazz{" +
                "clazzno=" + clazzno +
                ", cname='" + cname + '\'' +
                '}';
    }
}
