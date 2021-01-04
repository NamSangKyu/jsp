<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
	}
	td{
		border:1px solid black;
		padding:5px;
	}
</style>
</head>
<body>
<h1>로또번호 생성결과</h1>
<hr>
<table>
	<%
		int[][] lotto = (int[][])request.getAttribute("lotto");
		for(int i=0;i<lotto.length;i++){
			out.write("<tr>");
				for(int j=0;j<lotto[i].length;j++)
					out.write("<td>"+lotto[i][j]+"</td>");
			out.write("</tr>");
		}
	%>
</table>
</body>
</html>







