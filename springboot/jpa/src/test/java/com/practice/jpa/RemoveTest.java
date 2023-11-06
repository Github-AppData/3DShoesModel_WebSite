package com.practice.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.jpa.Repository.MemoRepository;

//TEST코드 실행방법 : RUN -> Run As -> JUnit Test 실행
@SpringBootTest
public class RemoveTest {
 
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void DeleteDummies() {
        Long id = 10L;
 
        memoRepository.deleteById(id);
    }
}