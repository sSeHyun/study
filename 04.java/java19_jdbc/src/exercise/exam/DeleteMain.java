package exercise.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeleteMain {
	
	final static String DRV = "com.mysql.cj.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/board";
	final static String USR = "root";
	final static String PWD = "12345";
	

	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int row = 0;
		
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			sql = "delete from emp where empno=?";	
			pstmt = conn.prepareStatement(sql);
			
			System.out.print("삭제할 사원의 번호를 입력하세요 >");
			int empno=scan.nextInt();
			pstmt.setInt(1,empno);
				
			row = pstmt.executeUpdate();
			System.out.println("emp테이블에 " + row + "건이 성공적으로 삭제되었습니다!");
			
		} catch (Exception e) {
			System.out.println("DB연결실패!!!");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();				
			} catch (Exception e2) {
				// dummy
			}			
		}
		
	}
}
