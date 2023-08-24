package com.practice.jpa;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.jpa.Entity.Memo;
import com.practice.jpa.Repository.MemoRepository;

//TEST코드 실행방법 : RUN -> Run As -> JUnit Test 실행
@SpringBootTest
public class ReadTest {
 
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void SelectDummies() {
 
        Long id = 10L;
 
        Optional<Memo> result = memoRepository.findById(id);
 
        System.out.println("=============================");
 
        if(result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }
}