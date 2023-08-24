package com.practice.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.jpa.Repository.MemoRepository;

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