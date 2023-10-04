package com.practice.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.jpa.Entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
