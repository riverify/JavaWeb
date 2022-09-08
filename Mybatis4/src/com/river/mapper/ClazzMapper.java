package com.river.mapper;

import com.river.entity.Clazz;

import java.util.List;

public interface ClazzMapper {
    // 查询指定学生所在班级号的班级信息　
    Clazz selectOne(Integer clazzno);

    // 查询所有的班级信息
    List<Clazz> selectAll();


    // 多表查询
    List<Clazz> selectAll2();


}
