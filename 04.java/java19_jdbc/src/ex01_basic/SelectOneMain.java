package ex01_basic;

import java.sql.*;

public class SelectOneMain {

	// 1. Oracle
	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "scott";
	final static String PWD = "tiger";
	
	public static void main(String[] args) {		
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	    
		try {
			Class.forName(DRV);
			conn=DriverManager.getConnection(URL,USR,PWD);
			String sql="select * from emp where empno=? ";
			int row=0;
			
			//emp테이블에서 1건 읽기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 9998);
			//pstmt.setString(2, "CLERK");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				int empno = rs.getInt(1);        // empno
				String ename = rs.getString(2);     // ename
				String job = rs.getString("job"); 
				int mgr = rs.getInt("MGR"); 
				String hiredate = rs.getString("hiredate");  
				int sal = rs.getInt("sal");  
				int comm = rs.getInt("comm");  
				int deptno = rs.getInt("deptno");
				
				System.out.println("[9999사원정보]");
				System.out.println(empno + ", " 
						 + ", " + ename
						 + ", " + job
						 + ", " + mgr
						 + ", " + hiredate
						 + ", " + sal
						 + ", " + comm
						 + ", " + deptno);
			
			}
			else {
				System.out.println("사원정보를 찾지 못했습니다.");
			}
			
			
			
		} catch (Exception e) {
			System.out.println("DB연결 실패!");
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();				
			} catch (Exception e2) {
				// dummy
			}
			
		}
	}

}
