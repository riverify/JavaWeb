package com.river.test;

import com.river.entity.Employee;
import com.river.mapper.EMPMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


// 动态sql

public class TestA {
    public static void main(String[] args) throws IOException {
        // 解析xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        // 获得sqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得session对象
        SqlSession sqlSession = factory.openSession(true);

        // 执行方法
        EMPMapper mapper = sqlSession.getMapper(EMPMapper.class);

        List<Employee> list = mapper.selectMore("CLERK", 0);

        System.out.println(list);

        list = mapper.selectMore2("", 20);

        System.out.println(list);

        Employee e = new Employee();
        e.setEmpno(7369);
        e.setSal(15000d);
        mapper.update(e);

        list = mapper.selectMore2("", 20);
        System.out.println(list);


        // 关闭sqlSession
        sqlSession.close();
        inputStream.close();

    }
}
