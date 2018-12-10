package edu.spring.ex02.jdbc;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex.domain.Board;
import edu.spring.ex.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
				"file:src/main/resources/spring/application-config.xml",
				"file:src/main/webapp/WEB-INF/mvc-config.xml"
		}
		)
@WebAppConfiguration
public class DaoTest {
	private final Logger logger = 
			LoggerFactory.getLogger(DaoTest.class);
	
	@Autowired private BoardDao boardDao;
	
	@Test
	public void doTest() {
//		selectAllTest();
//		selectOneTest();
//		insertTest();
//		updateTest();
		deleteTest();
	}
	
	private void selectAllTest() {
		List<Board> list = boardDao.read();
		for (Board b : list) {
			logger.info(b.toString());
		}
	}
	
	private void selectOneTest() {
		Board board = boardDao.read(1);
		logger.info(board.toString());	
	}
	
	private void insertTest() {
		Board b = new Board();
		b.setTitle("MyBatis insert 테스트");
		b.setContent("MyBatis-Spring-Oracle 게시글 입력 테스트");
		b.setUserId("guest");
		
		int result = boardDao.create(b);
		logger.info("insert Result = {}", result);
				
	}
	
	private void updateTest() {
		Board b = new Board();
		b.setBno(1);
		b.setTitle("결과");
		b.setContent("업데이트성공");
		
		int result = boardDao.update(b);
		logger.info("update Result = {}", result);
	}
	
	private void deleteTest() {
		
		int result = boardDao.delete(3);
		logger.info("delete = {}",result);
		
	}
} // end class DaoTest()
