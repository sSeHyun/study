<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 실습. add(), sub(), mul(), div() 메서드 -->
<%!
	public int add(int num1,int num2){
	int result=num1+num2;
	return result; 
	}
	public int sub(int num1,int num2){
		int result=num1-num2;
		return result;
	}
	public int mul(int num1,int num2){
		int result=num1*num2;
		return result;
	}
	public int div(int num1,int num2){
		int result=num1/num2;
		return result;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	add(10,10)=<%= add(10,10) %><br>
	sub(10,10)=<%= sub(10,10) %><br>
	mul(10,10)=<%= mul(10,10) %> <br>
	div(10,10)=<%= div(10,10) %><br>

	<hr/>
	10곱하기 20은 <%= mul(10,20) %> 입니다.<br>
	<hr />
	<% 	int val1=10;
		int val2=20;
		int result=add(val1,val2);		
	%>
	<%= val1 %> + <%= val2 %> =<%= result %>
	
</body>
</html>