<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String forwardPage="";
	String param_page=request.getParameter("code");
	
	if(param_page.equals("A")){
		forwardPage="./viewPage/a.jsp";
	}else if(param_page.equals("B")){
		forwardPage="./viewPage/b.jsp";	
	}
	else if(param_page.equals("C")){
		forwardPage="./viewPage/c.jsp";		
	}

%>



<h1>jsp0606_view.jsp</h1>
<jsp:forward page="<%=forwardPage %>"></jsp:forward>