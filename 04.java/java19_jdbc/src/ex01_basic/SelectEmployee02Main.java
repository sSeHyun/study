package ex01_basic;

import java.sql.*;
import javax.swing.JOptionPane;

public class SelectEmployee02Main {
	
	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "scott";
	final static String PWD = "tiger";
	
	public static void main(String[] args) {
	      
		// 실습2. JOptionPane으로 부서번호를 입력받아서 부서명출력하기(join)
	    // select empno, ename, emp.deptno, dname 
	    //   from emp emp, dept dpt 
	    //  where emp.deptno = ? 
	    //    and emp.deptno = dpt.deptno;
	    // 사원번호, 사원이름, 부서번호, 부서이름  	 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int row = 0;
		ResultSet rs = null;
		
		
		String strDeptno = JOptionPane.showInputDialog("부서번호를 입력하세요.");
		int intDeptno=Integer.parseInt(strDeptno);	//부서번호
		
		try {
			Class.forName(DRV);
			conn=DriverManager.getConnection(URL,USR,PWD);
			sql=" select empno, ename, emp.deptno, dname  "
					+ "from emp emp, dept dpt "
					+ "where emp.deptno = ? and emp.deptno = dpt.deptno";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, intDeptno);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				int empno = rs.getInt(1);        
				String ename = rs.getString(2);     
				String dname = rs.getString("dname"); 
				int deptno = rs.getInt("deptno");	
				
				System.out.println(String.format("%d\t%s\t%s\t%d", empno, ename,dname, deptno));
				
				
				
			}
			
		} catch (Exception e) {
			System.out.println("DB연결실패!!!");
			e.printStackTrace();
		}finally {
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
