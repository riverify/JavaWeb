package com.river.test;

import com.river.entity.Employee;
import com.river.mapper.EMPMapper4;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestE {
    public static void main(String[] args) throws IOException {
        // 解析xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        // 获得sqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得session对象　true：自动提交
        SqlSession sqlSession = factory.openSession(true);

        // 执行方法
        EMPMapper4 mapper = sqlSession.getMapper(EMPMapper4.class);

        Employee e = mapper.selectOne(7499, "ALLEN");

        System.out.println(e);

        // 关闭sqlSession
        sqlSession.close();
        inputStream.close();

    }
}
