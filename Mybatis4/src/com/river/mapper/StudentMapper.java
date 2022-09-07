package com.river.mapper;

import com.river.entity.Student;

import java.util.List;

public interface StudentMapper {
    // 查询所有学生
    List<Student> selectAll();
}
