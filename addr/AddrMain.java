package addr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
				
			} else if(cmd.equals("list")) {
				ArrayList<Addr> addrList = selectAddresses();
				
				System.out.println("========= 주소록 목록 =========");
				for(int i = 0; i < addrList.size(); i++) {
					Addr addr = addrList.get(i);
					System.out.println("번호 : " + addr.getIdx());
					System.out.println("이름 : "  + addr.getName());
					System.out.println("주소 : "  + addr.getAddress());
					System.out.println("전화번호 : " + addr.getPhone());
					System.out.println("==============================");
				}
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

	
	public static ArrayList<Addr> selectAddresses() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/a1?serverTimezone=UTC";
		String user = "root";
		String pass = "";
		
		ArrayList<Addr> addrList = new ArrayList<>();
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();

			String sql = "SELECT * FROM t_addr";
			
			System.out.println("sql : " + sql);
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) { // 다음 로우로 이동 다음이 있으면 true 반환, 없으면 false 반환
				
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				
				Addr a1 = new Addr(idx, name, address, phone);				
				addrList.add(a1);
			}
						
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
		
		return addrList;
	}
}
