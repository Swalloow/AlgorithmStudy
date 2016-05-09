import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PhoneBook {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String dburl = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(dburl, "bookmaster", "book");
			
			Scanner in = new Scanner(System.in);
			int menu;
			boolean sw = true;
			
			while(sw) {
				System.out.println("=================");
				System.out.println("| 1. 번호 조회            |");
				System.out.println("| 2. 번호 입력            |");
				System.out.println("| 3. 종료                   |");
				System.out.println("=================");
				System.out.println("메뉴를 선택하세요 : ");
				
				menu = Integer.parseInt(in.nextLine());
				
				switch(menu) {
				case 1:
					pstmt = con.prepareStatement("SELECT * FROM book");
					rs = pstmt.executeQuery();
					
					System.out.println("이름\t 전화번호\t 나이");
					
					while(rs.next()) {
						System.out.println(rs.getString("name")+"\t");
						System.out.println(rs.getString("phone_number")+"\t");
						System.out.println(rs.getInt("age")+"\t");
						System.out.println();
					}
					break;
					
				case 2:
					String name, phone_number;
					int age;
					System.out.println("이름을 입력하세요 ");
					name = in.nextLine();
					
					System.out.println("전화번호를 입력하세요 ");
					phone_number = in.nextLine();
					
					System.out.println("나이를 입력하세요 ");
					age = Integer.parseInt(in.nextLine());
					
					pstmt = con.prepareStatement("INSERT INTO book VALUES(?,?,?)");
					pstmt.setString(1, name);
					pstmt.setString(2, phone_number);
					pstmt.setInt(3, age);
					pstmt.executeUpdate();
					break;
				
				case 3:
					sw = false;
					break;
				}
			}
			
		} catch (IllegalArgumentException e) {
			System.out.println("입력 형태를 확인하세요");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {con.close();} catch (Exception e) {}
			}
			if(pstmt != null) {
				try {pstmt.close();} catch (Exception e) {}
			}
			if(rs != null) {
				try {rs.close();} catch (Exception e) {}
			}
		}
	}
}
