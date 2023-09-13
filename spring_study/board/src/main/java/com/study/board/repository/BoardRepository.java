package com.study.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
}
