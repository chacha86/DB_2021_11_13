package addr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddrMain {

	public static void main(String[] args) {

		// 자동임포트 : 컨트로 + (좌)쉬프트 + O
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/a1?serverTimezone=UTC";
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
			String sql = "SELECT * FROM t_addr";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("idx"));
				System.out.println(rs.getString("name")); // 문자열로 리턴
				System.out.println(rs.getString("address")); // 문자열로 리턴
				System.out.println(rs.getString("phone")); // 문자열로 리턴
				System.out.println("========================");
			}

		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
		}

	}

}
