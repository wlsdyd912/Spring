package edu.spring.ex.domain;

import java.util.Date;

public class Reply {
	private int rno; // 댓글 번호 - 고유키(primary key)
	private int bno; // 댓글이 달린 게시글의 번호 - 외래키(foreign key)
	private String rtext; // 댓글 내용 - not null
	private String userId; // 댓글 작성자 아이디 - not null, 외래키
	private Date regDate; // 댓글 작성(최종 수정) 시간

	public Reply() {
	}

	public Reply(int rno, int bno, String rtext, String userId, Date regDate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.rtext = rtext;
		this.userId = userId;
		this.regDate = regDate;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getRtext() {
		return rtext;
	}

	public void setRtext(String rtext) {
		this.rtext = rtext;
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

	@Override
	public String toString() {
		String reply = String.format("Reply(rno:%d, bno: %d, rtext:%s, userId:%s)", 
				rno, bno, rtext, userId);
		return reply.toString();
	}

}// end class Reply()
