package com.river.test;

import com.river.entity.Student;
import com.river.mapper.StudentMapper;
import com.river.util.DBUtil;

import java.util.List;

public class TestF {
    public void findAll() {
        StudentMapper mapper = DBUtil.getSqlSession().getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();

    }
}
