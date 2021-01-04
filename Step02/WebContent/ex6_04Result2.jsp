<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력한 숫자만큼 반복 수행</h1>
	<table border="1">
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>글내용</th>
	</tr>
	<%
		int ea = Integer.parseInt(request.getParameter("ea"));
		for(int i=ea;i>0;i--){
			%>
			<tr>
				<td><%=i %></td>
				<td>제목<%=i %></td>
				<td>내용<%=i%></td>
			</tr>			
		<%	
		}
	%>
	</table>
</body>
</html>