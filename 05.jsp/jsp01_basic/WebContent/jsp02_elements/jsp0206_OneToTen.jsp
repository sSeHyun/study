<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<!-- 실습. 1~100합을 출력해 보기 -->

	1~10까지의 합은 <%= 1+2+3+4+5+6+7+8+9+10 %>입니다.<br>
	
	<% int sum=0; %>
	<% for(int i=1;i<101;i++){
		sum+=i;
	}%>
	1~100까지의 합은 <%= sum %>입니다. <br>

