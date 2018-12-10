package edu.spring.ex.service;

import java.util.List;

import edu.spring.ex.domain.Board;

public interface BoardService {

	List<Board> select();
	Board select(int bno);
	int insert(Board board);
	int update(Board board);
	int delete(int bno);
	
}
