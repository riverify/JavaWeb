package com.river.test;

import com.river.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestA {
    public static void main(String[] args) throws IOException {
        // 解析xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        // 获得sqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获得session对象
        SqlSession sqlSession = factory.openSession();
        // 执行方法
        List<Employee> list = sqlSession.selectList("com.river.mapper.EMPMapper.selectAll");

        System.out.println(list);

        // 关闭
        sqlSession.close();

    }
}
