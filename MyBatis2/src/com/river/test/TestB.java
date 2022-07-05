package com.river.test;

import com.river.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestB {
    public static void main(String[] args) throws IOException {
        // 解析xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        // 获得sqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得session对象
        SqlSession sqlSession = factory.openSession();

        /////////////////////////////////////////////////////////////////////////////////////////////
        // 执行方法
        // 只有一个参数传入的时候
        Employee employee = sqlSession.selectOne("com.river.mapper.EMPMapper2.selectOne", 7499);
        // 当存在多个参数传入时
        // 传入对象
        Employee e = new Employee();
        e.setEmpno(7499);
        e.setEname("ALLEN");
        Employee employee2 = sqlSession.selectOne("com.river.mapper.EMPMapper2.selectOne2", e);
        // 传入集合 (Map集合)
        Map<String, Object> map = new HashMap<>();
        map.put("a", 7499);
        map.put("b", "ALLEN");
        Employee employee3 = sqlSession.selectOne("com.river.mapper.EMPMapper2.selectOne3", map);
        /////////////////////////////////////////////////////////////////////////////////////////////


        // 输出
        System.out.println(employee);
        System.out.println(employee2);
        System.out.println(employee3);

        // 关闭sqlSession
        sqlSession.close();
        inputStream.close();

    }
}
