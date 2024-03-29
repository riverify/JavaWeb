package com.river.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer sid;
    private String sname;
    private Integer clazzno;

    private Clazz cla;    // 表示一个班级的对象（一个学生对应一个班级）

    public Student() {
    }

    public Student(Integer sid, String sname, Integer clazzno) {
        this.sid = sid;
        this.sname = sname;
        this.clazzno = clazzno;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getClazzno() {
        return clazzno;
    }

    public void setClazzno(Integer clazzno) {
        this.clazzno = clazzno;
    }

    public Clazz getCla() {
        return cla;
    }

    public void setCla(Clazz cla) {
        this.cla = cla;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", clazzno=" + clazzno +
                ", cla=" + cla +
                '}';
    }
}
