package edu.spring.ex.domain;

import java.util.Date;

// MVC 아키텍처의 Model 클래스
// VO(Value Object), DTO(Data Transfer Object)
public class Board {
	private int bno; // 글번호
	private String title; // 글제목
	private String content; // 글 본문(내용)
	private String userId; // 글 작성자 아이디
	private Date regDate; // 글 작성 (최종 수정) 시간
	private int readCnt; // 글 조횟수
	private int replyCnt; // 댓글수
	
	public Board() {}

	public Board(int bno, String title, String content, String userId, Date regDate, int readCnt, int replyCnt) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.regDate = regDate;
		this.readCnt = readCnt;
		this.replyCnt = replyCnt;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	
	@Override
	public String toString() {
		String board = String.format("Board(bno:%d, title:%s, content:%s, userId:%s, regDate:%s, readCnt:%d, replyCnt:%d)"
				, bno, title, content, userId, regDate, readCnt, replyCnt );
		return board;
	}
}
