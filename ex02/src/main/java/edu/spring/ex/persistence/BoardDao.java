package edu.spring.ex.persistence;

import java.util.List;

import edu.spring.ex.domain.Board;

public interface BoardDao {
	
	List<Board> read(); 
	Board read(int bno);
	int create(Board board);
	
	/* DB 테이블에서 해당 글번호의 제목과 내용을 수정하는 메소드
	 * @param board - 수정할 글번호, 글제목, 글내용
	 * @return 수정(update) 성공이면 1, 실패면 0
	 */
	int update(Board board);
	
	/**
	 * 해당 글번호의 게시글을 DB 테이블에서 삭제하는 메소드
	 * @param bno - 삭제할 글 번호
	 * @return 삭제(delete) 성공이면 1, 실패면 0
	 */
	int delete(int bno);
	
	int update(int bno, int increment);
	
	
} // end interface BoardDao
