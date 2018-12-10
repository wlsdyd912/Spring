package edu.spring.ex.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex.domain.Board;
import edu.spring.ex.persistence.BoardDao;
import edu.spring.ex.persistence.BoardDaoImple;

@Service // 스프링 컨테이너에 서비스 콤포넌트로 등록(설정)
public class BoardServiceImple implements BoardService {

	private final Logger logger = 
			LoggerFactory.getLogger(BoardDaoImple.class);
	
	
	@Autowired private BoardDao boardDao;
	
	public List<Board> select() {
		logger.info("select() 호출");
		
		
		return boardDao.read();
	}

	public Board select(int bno) {
		logger.info("select(bno) 호출");
		// TODO: 글번호 검색이 성공하면 ,글 죄횟구를 1증가
		return boardDao.read(bno);
	}

	public int insert(Board board) {
		logger.info("insert() 호출");
		
		// TODO 새 글작성 성공 후 tbl_member 테이블의 point를 증가
		return boardDao.create(board);
	}

	public int update(Board board) {
		logger.info("update() 호출");
		
		
		// TODO Auto-generated method stub
		return boardDao.update(board);
	}

	public int delete(int bno) {
		logger.info("delete() 호출" ); 
		// TODO Auto-generated method stub
		return boardDao.delete(bno);
	}

}
