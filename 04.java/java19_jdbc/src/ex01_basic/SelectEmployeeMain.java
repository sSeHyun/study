package ex01_basic;


import java.sql.*;
import java.io.*;

public class SelectEmployeeMain {
	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "scott";
	final static String PWD = "tiger";

	public static void main(String[] args) throws FileNotFoundException {
		// 실습1. select empno, ename, job from emp;
	    // 사원정보를 employee.html(table태그)출력파일로 저장
	    // src/com/lec/ex01_basic/employees.html
	    // String data = "<table></table>";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OutputStream os = new FileOutputStream("src/ex01_basic/employee.html");
		String sql = "";
		String data = "";
		
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			sql = "select * from emp";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			data = "<table border = 1 solid><th>사원번호</th><th>사원명</th><th>직급</th><th>매니저</th><th>입사일</th><th>급여</th><th>커미션</th><th>부서번호</th>";
			os.write(data.getBytes());
			
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString("job");
				int mgr = rs.getInt("MGR");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				System.out.println(empno + ", " + ename + ", " + job + ", " + mgr + ", " + hiredate + ", " + sal + ", " + comm + ", " + deptno);
				
				data = "<tr><td>" + empno + "</td><td>" + ename + "</td><td>" + job + "</td><td>" + mgr + "</td><td>" + hiredate + "</td><td>" + sal
						+ "</td><td>" + comm + "</td><td>" + deptno + "</td></tr>";
				os.write(data.getBytes());
			}
			
			data = "</table>";
			os.write(data.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결실패");
		} finally {
			try {
				if (rs != null) rs.close(); 
				if (pstmt != null) pstmt.close(); 
				if (conn != null) conn.close();
				os.flush();
				os.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
