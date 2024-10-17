<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>전체 회원보기</h1>
	<% 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:mysql://localhost:3306/jspstudy";
			String usr = "root";
			String pw = "12345";
			String sql = "select * from member";
			
			conn = DriverManager.getConnection(url, usr, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
	%>
	
			<table border="1">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
	<%
			while(rs.next()){
		%>
				<tr>
					<td><%= rs.getString("id") %></td>
					<td><%= rs.getString("pwd") %></td>
					<td><%= rs.getString("name") %></td>
					<td><%= rs.getString("email") %></td>
				</tr>
	<%
			}
	%>
			</table>
		<% 
			
		} catch(Exception e) {
	%>
			에러 : <%= e.getMessage() %>
	<%
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e1) {
				// dummy
			}
		}
	%>

</body>
</html>