<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>회원정보추가하기</h1>
	<form method="post">
		<table board="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" placeholder="아이디를 입력하세요."/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" placeholder="비밀번호를 입력하세요."/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" placeholder="이름을 입력하세요."/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" placeholder="이메일을 입력하세요."/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="회원추가하기" /></td>
			</tr>
		</table>
	</form>
	
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {	
			String url = "jdbc:mysql://localhost:3306/jspstudy";
			String usr = "root";
			String pw = "12345";
			String sql = "insert into member(id, pwd, name,email) values(?, ?, ?, ?)";
	
			conn = DriverManager.getConnection(url, usr, pw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
				
			int row = pstmt.executeUpdate();
			
			%>
			<h3 style="color: blue;"><%= id %>에 회원정보가 성공적으로 추가되었습니다!!</h3>		
<%
		} catch(Exception e) {
%>
			<h3 style="color: red;"><%= id %>에 해당되는 회원정보를 추가하지못했습니다</h3>			
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