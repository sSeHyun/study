<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>회원 삭제하기</h1>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
	
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/jspstudy";
			String usr = "root";
			String pw = "12345";
			String sql = "delete from member where id=?";
			
			conn = DriverManager.getConnection(url, usr, pw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			int row=pstmt.executeUpdate();
			
			%>			
			<h3 style="color: blue;"><%= id %>에 회원정보가 성공적으로 삭제되었습니다!!</h3>
		<%
		}catch(Exception e) {
	%>
			에러 : <%= e.getMessage() %>
	<%
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e1) {
				// dummy
			}
		}
	%>

</body>
</html>

