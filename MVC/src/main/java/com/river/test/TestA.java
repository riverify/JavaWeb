package com.river.test;

import com.river.entity.User;
import com.river.mapper.UserMapper;
import com.river.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

public class TestA {
    public static void main(String[] args) {
        SqlSession sqlSession = DBUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User zs = mapper.selectOne("zs", "123");
        System.out.println(zs);
    }
}
