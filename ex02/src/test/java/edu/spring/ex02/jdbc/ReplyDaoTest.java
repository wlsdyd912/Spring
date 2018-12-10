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

import edu.spring.ex.domain.Reply;
import edu.spring.ex.persistence.ReplyDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
				"file:src/main/resources/spring/application-config.xml",
				"file:src/main/webapp/WEB-INF/mvc-config.xml" }
		)
@WebAppConfiguration
public class ReplyDaoTest {

	private final Logger logger = 
			LoggerFactory.getLogger(ReplyDaoTest.class);
	
	@Autowired private ReplyDao replyDao;
	
	@Test
	public void doTest() {
//		replyInsertTest();
//		selectAllTest();
//		updateTest();
//		deleteTest();
		selectBno();
	}
	
	private void replyInsertTest() {
		Reply reply = new Reply();
		reply.setBno(21);
		reply.setRtext("처음 작성하는 댓글...");
		reply.setUserId("guest");
		
		int result = replyDao.create(reply);
		logger.info("댓글 insert 결과 : {}", result);
	}
	
	private void selectAllTest() {
		List<Reply> list = replyDao.read(21);
		for (Reply r : list) {
			logger.info(r.toString());
		}
	}
	
	private void updateTest() {
		Reply reply = new Reply();
		reply.setRno(1);
		reply.setRtext("댓글 수정 test....");
		
		int result = replyDao.update(reply);
		logger.info("댓글 update 결과 : {}", result);
	}
	
	private void deleteTest() {
		
		int result = replyDao.delete(4);
		logger.info("delete 결과 : {}", result);
	}

	private void selectBno() {
		
		int result = replyDao.selectBno(2);
		logger.info("selectBno 결과 : {}", result);
	}
}
