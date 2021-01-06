<%@page import="service.BoardService"%>
<%@page import="dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container{
		height: 600px;
		/* background-color: lime; */
		width:1200px;
		margin:0 auto;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$(".board tr").click(function(){
			if($(this).index() == 0) return;
			var bno = $(this).find("td").first().html();
			location.href = "<%=request.getContextPath()%>/board/board_view.jsp?bno="+bno;
			console.log($(this).find("td").first().html());
		});
	});
</script>
</head>
<body> 
<%
	ArrayList<BoardDTO> list = BoardService.getInstance().selectBoardList();
%>
<style>
	.board{
		margin:20px auto;
		border-collapse: collapse;
	}
	th, td{
		padding: 10px;
		text-align: center;
	}
	th{
		border-top : 2px solid black;
		border-bottom : 2px solid black;
	}
	td{
		border-top : 1px solid black;
		border-bottom : 1px solid black;
	}
	tr:last-child > td {
		border-bottom : 2px solid black;
	}
	.title{
		width:500px;	
	}
	.writer{
		width:150px;	
	}
	.date{
		width:200px;
	}
</style>
<jsp:include page="/template/header.jsp" flush="false"></jsp:include>
	<div id="container">
		<table class="board">
			<tr>
				<th>글번호</th>
				<th class="title">제목</th>
				<th class="writer">작성자</th>
				<th class="date">작성일</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>싫어요</th>
			</tr>
			<%
				for(int i=0;i<list.size();i++){
					%>
					<tr>
						<td><%=list.get(i).getBno() %></td>
						<td><%=list.get(i).getTitle() %></td>
						<td><%=list.get(i).getWriter() %></td>
						<td><%=list.get(i).getbDate() %></td>
						<td><%=list.get(i).getbCount() %></td>
						<td><%=list.get(i).getbLike() %></td>
						<td><%=list.get(i).getbHate() %></td>
					</tr>					
					<%
				}
			%>
		</table>
	</div>
<jsp:include page="/template/footer.jsp" flush="false"></jsp:include>
	

</body>
</html>






