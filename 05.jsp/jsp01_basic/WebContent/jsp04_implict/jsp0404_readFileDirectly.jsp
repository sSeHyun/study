<%@page import="java.io.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>파일읽기(1) - 절대경로를 사용해서 파일 읽기</h1>
	작업 폴더 -> D:\sena\05.jsp\jsp01_basic\WebContent\jsp04_implict\sample.txt
	실제 폴더 -> D:\sena\05.jsp\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp01_basic\WebContent\jsp04_implict\sample.txt
	<hr />
	
	
	<%
		char[] buff = new char[128];
		int len = -1;
		String filePath = "D:/sena/05.jsp/jsp01_basic/WebContent/jsp04_implict/sample.txt";
		try(InputStreamReader fr = 
				new InputStreamReader(new FileInputStream(filePath), "utf-8")) {
			while((len=fr.read(buff)) != -1) {
				out.println(new String(buff, 0, len));
			}
		} catch(Exception e) {
			out.println("익셉션 = " + e.getMessage());
		}
	%>
	
</body>
</html>

