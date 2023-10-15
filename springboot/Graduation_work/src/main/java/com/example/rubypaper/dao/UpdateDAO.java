package com.example.rubypaper.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateDAO {

    private final SqlSession sqlSession;

    @Autowired
    public UpdateDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int cartUpdateIsDelete(String shoes_id) throws Exception {
        try {
            return sqlSession.update("com.example.rubypaper.mapper.CartMapper.cartUpdateIsDelete", shoes_id);
        } finally {
            // 세션을 닫을 필요가 없음
        }
    }
}
