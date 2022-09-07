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

public class TestB {
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
        // a查询所有班级的信息
        List<Clazz> clazzes = clazzMapper.selectAll();

        // b查询班级中对应的学生的信息

//        for (Clazz clazz : clazzes) {
//            // 获取指定班级的所有学生信息
//            List<Student> students = studentMapper.selectMore(clazz.getClazzno());
//            // 遍历该班级学生
//            for (Student student : students) {
//                // 为该班级学生set该Clazz对象
//                student.setCla(clazz);
//                // 打印该学生所有信息
//                System.out.println(student);
//            }
//        }

        for (Clazz clazz : clazzes) {
            // 获取指定班级的所有学生信息
            List<Student> students = studentMapper.selectMore(clazz.getClazzno());
            // 将学生集合保存进该clazz对象中
            clazz.setStd(students);
            // 打印输出
            System.out.println(clazz);
        }


        // 关闭sqlSession
        sqlSession.close();
        inputStream.close();

    }
}
