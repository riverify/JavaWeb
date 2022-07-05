package com.river.test;

import com.river.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestA {
    public static void main(String[] args) throws IOException {
        // 解析xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        // 获得sqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得session对象
        SqlSession sqlSession = factory.openSession();

        // 执行方法 3种
        // 查询方式Ａ：适合于结果集返回的是多条数据的时候
        List<Employee> list = sqlSession.selectList("com.river.mapper.EMPMapper.selectAll");
        // 查询方式Ｂ：适用于查询返回最多是一条的结果集
        Employee employee = sqlSession.selectOne("com.river.mapper.EMPMapper.selectOne");
        // 查询方式Ｃ：希望可以通过数据库中的某一列快速找到这一列对应的结果集
        // selectMap("调用的方法", "数据库某一列作为key")
        Map<Object, Object> map = sqlSession.selectMap("com.river.mapper.EMPMapper.selectMap", "EMPNO");

        // 输出
        System.out.println(list);
        System.out.println(employee);
        System.out.println(map.get(7499));

        // 关闭sqlSession
        sqlSession.close();
        inputStream.close();

    }
}
