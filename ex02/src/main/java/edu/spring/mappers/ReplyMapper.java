package edu.spring.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.spring.ex.domain.Reply;

public interface ReplyMapper {
	String SQL_INSERT = 
			"insert into ${tbl_reply}"
			+ " (${reply.bno}, ${reply.rtext}, ${reply.userid})"
			+ " values (#{bno}, #{rtext}, #{userId})";
	
	@Insert(SQL_INSERT)
	int create(Reply reply);
	
	String SQL_SELECT_ALL_REPLY_BY_BNO = 
			"select * from ${tbl_reply}"
			+ " where ${reply.bno} = #{bno}"
			+ " order by ${reply.rno} desc";
	
	@Select(SQL_SELECT_ALL_REPLY_BY_BNO)
	List<Reply> selectAll(int bno);
	
	// 어노테이션 방식의 Mapper 인터페이스를 사용하는 경우에는
	// 추상 메소드의 이름이 SqlSession 객체가 사용할 SQL 문의 아이디가 됨
	// -> Mapper 인터페이스에서는 메소드 overloading을 사용하면 안됨!
	// 모든 메소드의 이름은 다르게 선언해야 함!
	// @Select("select * from tbl_reply")
	// Reply selectAll(int rno, int bno);
	
	
	String SQL_UPDATE = 
			"update ${tbl_reply}"
			+ " set ${reply.rtext} = #{rtext}, ${reply.regdate} = sysdate"
			+ " where ${reply.rno} = #{rno}";
	
	@Update(SQL_UPDATE)
	int update(Reply reply);
	
	String SQL_DELETE = 
		"delete from ${tbl_reply}"
		+ " where ${reply.rno} = #{rno}";
	
	@Delete(SQL_DELETE)
	int delete(int rno);
	
	String SQL_SELECT_BNO = 
			"select bno from ${tbl_reply}"
			+ " where ${reply.rno} = #{rno}";
	
	@Select(SQL_SELECT_BNO)
	int selectBno(int rno);
	
} // end interface ReplyMapper
