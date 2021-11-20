package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {

		// 접속정보 4개
		// 자동임포트 : 컨트로 + (좌)쉬프트 + O
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/b_20211114?serverTimezone=UTC";
		String user = "root";
		String pass = "";

		try {
			// 1. 드라이버 세팅
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 획득
			conn = DriverManager.getConnection(url, user, pass);

			// 3. Statement 생성
			stmt = conn.createStatement();

			// 4. SQL 처리하고 결과 ResultSet에 받아오기
			// CRUD
			// 조회 - select
						
			String sql = "SELECT * FROM article";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getString("title"));
				System.out.println(rs.getString("body")); // 문자열로 리턴
				System.out.println(rs.getInt("id")); // 문자열로 리턴
				System.out.println("========================");
			}
			
			
			// 5. 조회 결과가 없는 sql
			// 추가 - insert
			// 수정 - update
			// 삭제 - delete
			
			String sql2 = "UPDATE article SET body = '내용5' WHERE id = 5";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql2);
			

		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
		}

	}

}
