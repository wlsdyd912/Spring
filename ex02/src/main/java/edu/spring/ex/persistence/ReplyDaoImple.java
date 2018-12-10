package edu.spring.ex.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex.domain.Reply;
import edu.spring.mappers.ReplyMapper;

@Repository
public class ReplyDaoImple implements ReplyDao{
	
	private final Logger logger = 
			LoggerFactory.getLogger(ReplyDaoImple.class);
	
	//DI, IoC
	@Autowired ReplyMapper replyMapper;
	
	public int create(Reply reply) {
		logger.info("create({})", reply.toString());
		
		return replyMapper.create(reply);
	}

	public List<Reply> read(int bno) {
		logger.info("read(bno={})", bno);
		return replyMapper.selectAll(bno);
	}

	public int update(Reply reply) {
		logger.info("update({})", reply.toString());
		
		return replyMapper.update(reply);
	}

	public int delete(int rno) {
		logger.info("delete(rno={})", rno);
		
		return replyMapper.delete(rno);
	}

	public int selectBno(int rno) {
		logger.info("selectBno(rno={})",rno);
		
		return replyMapper.selectBno(rno);
	}
	
	
} // end class ReplyDaoImple
