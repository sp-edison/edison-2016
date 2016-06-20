<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<%
	String message = (String)request.getAttribute("message");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDISON</title>
</head>
<body>
	<%=message%>
</body>
</html>