package com.example.rubypaper.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;

public class DatabaseManager {
    private SqlSessionFactory sqlSessionFactory;

    public DatabaseManager() {
        // MyBatis 설정 파일을 로드
        String resource = "classpath:mapper/CartMapper.xml"; // 설정 파일 경로
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);

        // SqlSessionFactory 초기화
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public SqlSession openSession() {
        // SqlSessionFactory를 사용하여 세션을 엽니다.
        return sqlSessionFactory.openSession();
    }
}
