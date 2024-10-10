package exercise.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertMain {
	
	final static String DRV = "com.mysql.cj.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/board";
	final static String USR = "root";
	final static String PWD = "12345";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int row = 0;
				
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) "
				+ " values(?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 9998);
			pstmt.setString(2, "홍길동");
			pstmt.setString(3, "사원");
			pstmt.setInt(4, 7369);
			pstmt.setString(5, "2024-10-08");
			pstmt.setInt(6, 1000);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 20);
		
			row = pstmt.executeUpdate();
			System.out.println("emp테이블에 " + row + "건이 성공적으로 추가 되었습니다!");
			
		} catch (Exception e) {
			System.out.println("DB연결실패!!!");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();				
			} catch (Exception e2) {
				// dummy
			}			
		}

	}

}
