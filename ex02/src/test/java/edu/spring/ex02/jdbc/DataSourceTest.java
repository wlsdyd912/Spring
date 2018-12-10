package edu.spring.ex02.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
				"file:src/main/resources/spring/application-config.xml",
				"file:src/main/webapp/WEB-INF/mvc-config.xml"
		}
		)
@WebAppConfiguration
public class DataSourceTest {
	
	// DI(Dependency Injection) : 의존성 주입
	// IOC(Inversion of Control) : 제어의 역전
	
	private final Logger logger = 
			LoggerFactory.getLogger(DataSourceTest.class);
	
	@Autowired
	private DataSource ds;
	// javax.sql.DataSource
	// |_DriverManagerDataSource
	
	@Autowired
	private SqlSessionFactory factory;
	
	private void testSqlSessionFactory() {
		logger.info("factory: " + factory);
		SqlSession session = factory.openSession();
		logger.info("session: " + session);
	}
	
	@Autowired
	private SqlSession session;
	
	private void testSqlSession() {
		logger.info("sqlSession: " + session);
	}
	
	@Test
	public void doTest() throws Exception {
		logger.info("ds: " + ds);
//		testDataSource();
		testSqlSessionFactory();
		testSqlSession();
	}
	
	private void testDataSource() throws Exception {
		// Connection Pool에서 DB 커넥션을 빌려옴
		Connection conn = ds.getConnection();
		logger.info("conn: " + conn);
		// 빌려온 DB 연결을 다시 Connection Pool에 반환
		String sql= "select title from tbl_board";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			logger.info(rs.getString(1));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
	}
	
}
