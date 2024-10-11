<%@page import="java.net.URLEncoder"%>
<%@page pageEncoding="UTF-8"%>
<%
	String value = "자바";
	String encodingValue = URLEncoder.encode(value, "euc-kr");
	response.sendRedirect("jsp0209_form.jsp?name=" + encodingValue);
%>

<!-- 로그인 form을 만들어서 MySQL.member 회원 id를 읽어서
	 회원정보를 출력하는 웹애플리케이션 작성하기
	 
	 Connection ,PreparedStatement, ResultSet 사용
	 
	 1. ex01_login.jsp 에서 id를 입력받기 submit(버튼)으로 전송
	 2. ex02_success.jsp에서 
	 	1) request.getParameter("id")
	 	2) Connection ,PreparedStatement, ResultSet 사용
	 		sql="select * from member"
	 		rs.next()
	 		rs.getInt() 또는 rs.getString()으로 
	 	ex02_success에서 회원아이디 회원 이름...등을 찍기
							 	회원아이디 : hong
							 	회원 이름 : 홍길동
							 	회원 성별 : male 
 -->