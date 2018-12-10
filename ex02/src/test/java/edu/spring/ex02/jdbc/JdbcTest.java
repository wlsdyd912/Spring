package edu.spring.ex02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;
// 테스트 클래스 (JdbcTest)를 Spring Junit 테스트 클래스에서 실행시킴
@RunWith(SpringJUnit4ClassRunner.class)

// (App,Servlet)컨텍스트 설정 파일의 위치 정의
// application-config.xml, mvc-config.xml
@ContextConfiguration(
		locations = {
				"file:src/main/resources/spring/application-config.xml",
				"file:src/main/webapp/WEB-INF/mvc-config.xml"
		})
// Web Application 설정을 사용
@WebAppConfiguration
public class JdbcTest {

	@Test // 테스트할 로직(소스코드)를 작성
	public void doTest() throws Exception {
		System.out.println("doTest...");
		
		// pom.xml에 추가한 oracle jdbc 라이브러리가 사용 가능한지 테스트
		DriverManager.registerDriver(new OracleDriver());
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		System.out.println("conn: " + conn);
		 
		String sql = "select * from tbl_member";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
	}
}
