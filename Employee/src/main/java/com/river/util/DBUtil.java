package com.river.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {

    private static SqlSessionFactory factory = null;

    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();

    static {
        InputStream inputStream = null;
        try {
            // 解析xml文件
            inputStream = Resources.getResourceAsStream("mybatis.xml");
            // 获得sqlSessionFactory工厂
            factory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 获得SqlSession对象
    public static SqlSession getSqlSession() {
        // 获得ThreadLocal中SqlSession对象
        SqlSession sqlSession = tl.get();
        // 若sqlSession还为被创建
        if (sqlSession == null) {
            // 创建SqlSession
            sqlSession = factory.openSession(true);
            // 添加到ThreadLocal
            tl.set(sqlSession);
        }
        return sqlSession;
    }

    // 关闭SqlSession
    public static void closeAll() {
        SqlSession sqlSession = tl.get();
        if (sqlSession != null) {
            sqlSession.close();
        }
        tl.set(null);
    }

}
