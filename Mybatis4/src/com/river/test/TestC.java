package com.river.test;

import com.river.entity.Clazz;
import com.river.entity.Student;
import com.river.mapper.ClazzMapper;
import com.river.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


// 多表查询的第二种方法　N+1

public class TestC {
    public static void main(String[] args) throws IOException {
        // 解析xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        // 获得sqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得session对象
        SqlSession sqlSession = factory.openSession(true);

        // 执行方法
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);

        // 查询所有学生所在的班级信息
        List<Student> students = studentMapper.selectAll2();
        for (Student student : students) {
            System.out.println(student);
        }

        List<Clazz> clazzes = clazzMapper.selectAll2();
        for (Clazz clazz : clazzes) {
            System.out.println(clazz);
        }

        // 关闭sqlSession
        sqlSession.close();
        inputStream.close();

    }
}
