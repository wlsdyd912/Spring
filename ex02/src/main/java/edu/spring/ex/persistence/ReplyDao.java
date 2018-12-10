package edu.spring.ex.persistence;

import java.util.List;

import edu.spring.ex.domain.Reply;

public interface ReplyDao {

	int create(Reply reply);
	List<Reply> read(int bno);
	int update(Reply reply);
	int delete(int rno);
	int selectBno(int rno);
}// end interface ReplyDao
