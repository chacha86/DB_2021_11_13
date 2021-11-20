package addr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AddrMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("add")) {
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("주소 : ");
				String address = sc.nextLine();
				System.out.print("전화번호 : ");
				String phone = sc.nextLine();
				
				insertAddress(name, address, phone);
				
			}
			
		}
		
	}

	public static void insertAddress(String name, String address, String phone) {

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

			// 4. SQL 처리
			String sql = "INSERT INTO t_addr SET `name` = '" + name + "', address = '" + address + "', phone = '" + phone + "'";
			System.out.println("sql : " + sql);
			stmt.executeUpdate(sql);

			// 5. 작업 다 했으면 자원 반납
			if(rs != null) {
				rs.close();				
			}
			if(stmt != null) {
				stmt.close();				
			}
			if(conn != null) {
				conn.close();				
			}
			
		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
		}
	}

}
