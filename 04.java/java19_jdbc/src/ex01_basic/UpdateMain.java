package ex01_basic;

import java.sql.*;
import java.util.Scanner;

public class UpdateMain {
	
	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "scott";
	final static String PWD = "tiger";
	
	
    // 실습. 9999사원정보를 수정하기
    // 소향, 부장, 100, 9999
    // sql = "update emp set ename=?, job=?, comm=? "
    //      + " where empno = ?"
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int row = 0;
		
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			sql = "update emp set ename=? ,job=?, comm=? where empno=? ";	
			pstmt = conn.prepareStatement(sql);
			
			
			System.out.print("수정할 사원의 이름> ");
			String ename=scan.next();
			pstmt.setString(1, ename);
			
			System.out.print("수정할 사원의 직급> ");
			String job=scan.next();
			pstmt.setString(2,job);
			
			System.out.print("수정할 사원의 보너스> ");
			int comm=scan.nextInt();
			pstmt.setInt(3,comm);
			
			System.out.print("수정할 사원의 사원번호> ");
			int empno=scan.nextInt();
			pstmt.setInt(4,empno);
			
			

			//선생님 
			//pstmt.setString(1, "소향");
			//pstmt.setString(2, "부장");
			//pstmt.setInt(3, 100);
			//pstmt.setInt(4, 9999);
			
			row = pstmt.executeUpdate();
			System.out.println("emp테이블에 " + row + "건이 성공적으로 수정 되었습니다!");
			
			System.out.println("=".repeat(80));
			System.out.println(String.format("%d\t%s\t%s\t%d", 
					empno, ename, job,comm));
			
		}catch (Exception e) {
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
