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

		try {

			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM article";

			System.out.println("sql : " + sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) { // 다음 로우로 이동 다음이 있으면 true 반환, 없으면 false 반환

				int idx = rs.getInt("idx");
				String title = rs.getString("title");
				String body = rs.getString("body");
				String writer = rs.getString("nickname");
				String regDate = rs.getString("regDate");

				Article a = new Article(idx, title, writer, body, regDate);
				articleList.add(a);
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
		}

		return articleList;
	}

	public void insertArticle(Article a) {

		try {

			Connection conn = getConnection();
			Statement stmt = conn.createStatement();

			String sql = "INSERT INTO article SET title = '" + a.getTitle() + "', `body` = '" + a.getBody()
					+ "', nickname = '" + a.getWriter() + "', regDate = '" + a.getRegDate() + "'";
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
