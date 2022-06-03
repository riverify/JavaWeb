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
        // 1.解析Mybatis.xml
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        // 2.获得session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3.获得session对象
        SqlSession sqlSession = factory.openSession();

        // 4.调用方法
        List<Employee> employees = sqlSession.selectList("a.b.selectAll");

        System.out.println(employees);

        // 5.关闭sqlSession
        sqlSession.close();
    }
}
