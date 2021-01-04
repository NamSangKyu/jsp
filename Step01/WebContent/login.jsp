<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%out.println(request.getParameter("id")); %>
	사용자로부터 입력받은 아이디는 <%=request.getParameter("id") %> 이고<br>
	암호는 <%=request.getParameter("pass") %> 입니다.<br>
</body>
</html>