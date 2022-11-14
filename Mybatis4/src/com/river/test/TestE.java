package com.river.test;

import com.river.entity.Clazz;
import com.river.mapper.ClazzMapper;
import com.river.util.DBUtil;

public class TestE {

    public static void main(String[] args) {
        new TestE().selectAll();
    }

    public void selectAll() {
        ClazzMapper mapper = DBUtil.getSqlSession().getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectOne(1);

        // 调用其他类中的查询
        new TestF().findAll();
    }
}
