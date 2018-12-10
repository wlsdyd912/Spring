package edu.spring.ex.service;

import java.util.List;

import edu.spring.ex.domain.Reply;

public interface ReplyService {

	int insert(Reply reply);
	List<Reply> select(int bno);
	int update(Reply reply);
	int delete(int rno);
	
} // end interface ReplyService
