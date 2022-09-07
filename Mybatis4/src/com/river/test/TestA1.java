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


// 多表查询的第一种方法　业务代码

public class TestA1 {
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
        // a查询所有学生信息
        List<Student> students = studentMapper.selectAll();

        // b查询所有学生班级号的班级信息
        for (Student student : students) {
//            System.out.println(student.getSname() + " ==> "
//                    + clazzMapper.selectOne(student.getClazzno()).getCname());
            Clazz cla = clazzMapper.selectOne(student.getClazzno());
            // 将查询的Clazz对象存入Student对象中
            student.setCla(cla);
            // 打印输出
            System.out.println(student);
        }


        // 关闭sqlSession
        sqlSession.close();
        inputStream.close();

    }
}
