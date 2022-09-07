package com.river.test;

import com.river.entity.Employee;
import com.river.mapper.EMPMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


// 动态sql

public class TestB {
    public static void main(String[] args) throws IOException {
        // 解析xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        // 获得sqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得session对象
        SqlSession sqlSession = factory.openSession(true);

        // 执行方法
        EMPMapper2 mapper = sqlSession.getMapper(EMPMapper2.class);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7369);
        list.add(7499);
        list.add(7698);
        List<Employee> employees = mapper.selectMore(list);
        System.out.println(employees);

        mapper.selectMore2("M");

        // 关闭sqlSession
        sqlSession.close();
        inputStream.close();

    }
}
