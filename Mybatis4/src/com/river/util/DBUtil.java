package com.river.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {

    private static SqlSessionFactory factory = null;

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

    // 获得sqlsession对象
    public static SqlSession getSqlSession() {
        return factory.openSession(true);
    }
}
