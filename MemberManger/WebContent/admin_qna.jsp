<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
	#container{
		width:1200px;
		margin:20px auto;
	}
</style>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	var pageNo = 1;//전역변수
	$(function(){
		
	});
</script>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<div id="container">
		<table>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>날짜</th>
			</tr>
		<c:forEach var="dto" items="${sessionScope.list }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${dto.title }</td>
				<td>${dto.writer }</td>
				<td>${dto.date }</td>
				<td>
				<c:choose>
					<c:when test="${dto.status==0}">않읽음</c:when>
					<c:when test="${dto.status==1}">읽음></c:when>
					<c:otherwise>답변완료</c:otherwise>
				</c:choose>
				</td>
			</tr>			
		</c:forEach>
		</table>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>












