<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 전송 버튼 클릭을 했을때 RouteTest 서블릿에서 
		result 폴더에 있는 route_result.jsp로 이동하여 입력한 내용을 출력-->
	<!-- <form action="../RouteTest"> -->
	<form action="<%=request.getContextPath() %>/RouteTest">
		<input type="text" name="txt"><button>전송</button>
	</form>
</body>
</html>