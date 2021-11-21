package board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import board.Article;

public class DBUtil {

	public void insertArticle(Article a) {

		try {

			Connection conn = getConnection();
			Statement stmt = conn.createStatement();

			String sql = "INSERT INTO article SET title = '" + a.getTitle() +"', `body` = '" + a.getBody() + "', nickname = '" + a.getWriter() + "', regDate = '" + a.getRegDate() + "'";
			System.out.println("sql : " + sql);
			stmt.executeUpdate(sql);

			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
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
