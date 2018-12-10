package edu.spring.ex.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex.domain.Reply;
import edu.spring.ex.persistence.BoardDao;
import edu.spring.ex.persistence.ReplyDao;

@Service
public class ReplyServiceImple implements ReplyService {
	
	private final Logger logger = 
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired private ReplyDao replyDao;
	@Autowired private BoardDao boardDao;
	
	public int insert(Reply reply) {
		logger.info("insert({}) 호출", reply.toString());
		
		// 1) tbl_reply 테이블에 새 댓글을 insert
		int result = replyDao.create(reply);
		if (result == 1) { // 새 댓글 insert가 성공한 경우
			// 2) tbl_board 테이블의 replycnt 컬럼위 값을 1 증가
			boardDao.update(reply.getBno(),1);
			
			// TODO: 3) 댓글을 작성한 사용자의 point를 증가
			
		}
		return result;
	}

	public List<Reply> select(int bno) {
		logger.info("select(bno={}) 호출", bno);
		
		return replyDao.read(bno);
	}

	public int update(Reply reply) {
		logger.info("update({}) 호출", reply.toString());
		
		return replyDao.update(reply);
	}

	public int delete(int rno) {
		logger.info("delete({}) 호출", rno);
		int bno = replyDao.selectBno(rno);
		
		int result = replyDao.delete(rno);
		if (result == 1) { // 댓글 삭제가 성공한 경우에는
			// TODO: tbl_board의 해당 bno의 replycnt 컬럼의 값을 1 감소
			boardDao.update(bno, -1);
		}
		return result;
	}

}
