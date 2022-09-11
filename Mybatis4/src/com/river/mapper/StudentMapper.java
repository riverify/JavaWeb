package com.river.mapper;

import com.river.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    // 查询所有学生
    List<Student> selectAll();

    // 查询指定班级号的学生
    List<Student> selectMore(Integer clazzno);

    // 多表查询操作
    List<Student> selectAll2();

    /**
     * mybatis 注解
     *
     * @return
     */
    @Select("select * from student")
    List<Student> selectAll3();
}
