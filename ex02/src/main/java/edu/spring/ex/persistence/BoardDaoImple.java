package edu.spring.ex.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex.domain.Board;

@Repository // 영속 계층(Persistence layer) 콤포넌트임을 설정
public class BoardDaoImple implements BoardDao {

	private static final String BOARD_MAPPER = 
			"edu.spring.mappers.BoardMapper";
	
	private final Logger logger = 
			LoggerFactory.getLogger(BoardDaoImple.class);
	
	// DI(Dependency Injection): 의존성 주입
	// spring 컨테이너가 생성한 객체(application-config.xml)를 자동으로 넣어줌
	@Autowired private SqlSession session;
	
	public List<Board> read() {
		logger.info("read() 메소드 호출");
		
		return session.selectList(BOARD_MAPPER + ".selectAll");
	}
	public Board read(int bno) {
		logger.info("read(bno={}) 호출", bno);
		
		return session.selectOne(BOARD_MAPPER + ".selectOne", bno);
	}
	
	public int create(Board board) {
		logger.info("create(title:{}, content:{}, userId:{}) 호출",
				board.getTitle(), board.getContent(), board.getUserId());
		
		
		return session.insert(BOARD_MAPPER + ".insert", board);
		
	}
	
	public int update(Board board) {
		logger.info("create(title:{}, content:{}, userId:{}) 호출",
				board.getTitle(), board.getContent(), board.getUserId());
		
		return session.update(BOARD_MAPPER + ".update", board);
	}
	
	public int delete(int bno) {
		
		return session.delete(BOARD_MAPPER + ".delete", bno);
	}
	public int update(int bno, int increment) {
		logger.info("update(bno={}, increment={}) 호출", bno, increment);
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("bno", bno);
		params.put("increment", increment);
		return session.update(BOARD_MAPPER + ".udateReplyCnt", params);
	}
}
