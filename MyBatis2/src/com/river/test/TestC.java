package com.river.test;

import com.river.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestC {
    public static void main(String[] args) throws IOException {
        // 解析xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        // 获得sqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得session对象　true：自动提交
        SqlSession sqlSession = factory.openSession(true);


        // 执行方法

        Employee e = new Employee();
//        e.setEname("Jian");
//        e.setJob("IT");
//        e.setMgr(7322);
//        e.setHireDate(new java.sql.Date(System.currentTimeMillis()));
//        e.setSal(7200d);
//        e.setComm(500d);
//        e.setDeptno(20);
//        e.setEmpno(7943);
//        e.setSal(9999d);

        // 添加操作
//        int insert = sqlSession.insert("com.river.mapper.EMPMapper3.insert", e);
        // 修改操作
//        int update = sqlSession.update("com.river.mapper.EMPMapper3.update", e);
        // 删除操作
        int delete = sqlSession.delete("com.river.mapper.EMPMapper3.delete", 7939);

        // 手动提交
//        sqlSession.commit();

        // 关闭sqlSession
        sqlSession.close();
        inputStream.close();

    }
}
