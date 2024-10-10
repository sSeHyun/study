package exercise.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectMain {
	
	final static String DRV = "com.mysql.cj.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/board";
	final static String USR = "root";
	final static String PWD = "12345";
	
	
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			String sql = "select * from emp where empno >= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			rs = pstmt.executeQuery();

			System.out.println("=".repeat(80));
			System.out.println("번호\t이름\t직급\t매니저\t입사일\t급여\t커미션\t부서번호");
			System.out.println("=".repeat(80));
			while(rs.next()) {
				int empno = rs.getInt(1);        
				String ename = rs.getString(2);     
				String job = rs.getString("job"); 
				int mgr = rs.getInt("MGR"); 
				String hiredate = rs.getString("hiredate");  
				int sal = rs.getInt("sal");  
				int comm = rs.getInt("comm");  
				int deptno = rs.getInt("deptno");	
				System.out.println(String.format("%d\t%s\t%s\t%d\t%s\t%d\t%d\t%d", 
						empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
			
		} catch (Exception e) {
			System.out.println("DB연결실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();				
			} catch (Exception e2) {
				// dummy
			}			
		}			
		
	}

}
