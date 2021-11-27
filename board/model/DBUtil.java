package board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import addr.Addr;
import board.Article;

public class DBUtil {
	
	public ArrayList<Article> getArticleList() {

		ArrayList<Article> articleList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {

			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM article";

			System.out.println("sql : " + sql);
			 rs = stmt.executeQuery(sql);

			while (rs.next()) { // 다음 로우로 이동 다음이 있으면 true 반환, 없으면 false 반환

				int idx = rs.getInt("idx");
				String title = rs.getString("title");
				String body = rs.getString("body");
				String writer = rs.getString("nickname");
				String regDate = rs.getString("regDate");

				Article a = new Article(idx, title, writer, body, regDate);
				articleList.add(a);
			}
			close(conn, stmt, rs);

		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
			close(conn, stmt, rs);
		}

		return articleList;
	}

	public void updateArticle(Article a) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {

			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "UPDATE article SET title = '" + a.getTitle() + "', `body` = '" + a.getBody() + "' WHERE idx = " + a.getNo();
			System.out.println("sql : " + sql);
			stmt.executeUpdate(sql);
			close(conn, stmt);

		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
			close(conn, stmt);
		}
	}
	
	public void insertArticle(Article a) {
		Connection conn = null;
		Statement stmt = null;
		
		try {

			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "INSERT INTO article SET title = '" + a.getTitle() + "', `body` = '" + a.getBody()
					+ "', nickname = '" + a.getWriter() + "', regDate = '" + a.getRegDate() + "'";
			System.out.println("sql : " + sql);
			stmt.executeUpdate(sql);
			close(conn, stmt);

		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
			close(conn, stmt);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
	
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		
		try {
			
			if(rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}			
			
		} catch(Exception e) {
			System.out.println("자원을 해제하는 중 문제 발생");
		}
		
		
	}
	
	public static Connection getConnection() {

		String url = "jdbc:mysql://localhost:3306/board?serverTimezone=UTC";
		String user = "root";
		String pass = "";

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
		}

		return conn;
	}

}
