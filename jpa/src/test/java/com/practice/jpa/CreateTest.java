package com.practice.jpa;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.jpa.Entity.Memo;
import com.practice.jpa.Repository.MemoRepository;

@SpringBootTest
public class CreateTest {
 
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void InsertDummies() {
 
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Memo memo = Memo.builder()
                    .memoText("Sample..." + i)
                    .build();
            //Create!
            memoRepository.save(memo);
        });
    }
}