package com.river.mapper;

import com.river.entity.Clazz;

public interface ClazzMapper {
    // 查询指定学生所在班级号的班级信息　
    Clazz selectAll(Integer clazzno);
}
