<%@page import="service.BoardService"%>
<%@page import="dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
<style type="text/css">
	#container{
		height: 600px;
		/* background-color: lime; */
		width:1200px;
		margin:0 auto;
	}
	#container table{
		width:600px;
		border-collapse: collapse;
		margin:0 auto;
	}
	#container th{
		width:150px !important;
		text-align: right;
		padding:5px;
	}
	#container td{
		width: 500px;
		padding:5px;
		height: 40px;
	}
	#container input{
		width: 100%;
		height:40px;
		box-sizing:border-box;
		border-width : 1px;
		border-radius: 5px;
	}
	h2{
		text-align: center;
	}
	.btn{
		text-decoration: none;
		background-color: #e8e8e8;
		width: 80px;
		display: inline-block;
		padding:5px 0px;
		font-weight:normal;
		border : 1px solid #585858;
		text-align:center;
		color : black;
		font-size:14px;
		box-sizing: border-box;
	}
	.btn:hover{
		background-color: #282828;
		color:#FFFFFF
	}
	.hate{
		transform: rotate(0.5turn);
	}
	.text_center{
		text-align: center;
	}
	.btn_like{
		width:64px;
		display: inline-block;
		color:black;
		text-decoration: none;
	}
</style>
</head>
<body>
<%
		if(session.getAttribute("login") == null || (boolean) session.getAttribute("login")==false){
			%>
				<script>
					location.href="<%=request.getContextPath()%>/index.jsp";
				</script>
			<%
		}
		//보낸 페이지 번호 
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardDTO dto = BoardService.getInstance().selectBoardDTO(bno);
%>
	<jsp:include page="/template/header.jsp" flush="false"></jsp:include>
	<div id="container">
		<h2>글조회 페이지</h2>
		<form action="process/board_write_process.jsp" method="post">
			<table>
				<tr>
					<th>제목</th>
					<td>
						<!-- 조회한 내용 -->
						<%=dto.getTitle() %>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<%=dto.getWriter() %>			
					</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>
						<%=dto.getbCount() %>
					</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>
						<%=dto.getbDate()%>
					</td>
				</tr>
				<tr>
					<th style="vertical-align: top;">내용</th>
					<td>
						<%=dto.getContent() %>
					</td>
				</tr>
				<tr>
					<th></th>
					<td class="text_center">
						<a href="#" class="btn_like">
							<img src="<%=request.getContextPath()%>/img/like.png">
							<!-- 좋아요 개수 -->
							<span><%=dto.getbLike() %></span>
						</a>
						<a href="#" class="btn_like">
							<img src="<%=request.getContextPath()%>/img/like.png" class="hate">
							<!-- 싫어요 개수 -->
							<span><%=dto.getbHate() %></span>
						</a>
					</td>
				</tr>
				<tr>
					<th><a href="javascript:history.back();" class="btn">목록보기</a></th>
					<td style="text-align: right;">
					<%
						if(dto.getWriter().equals(session.getAttribute("id"))){
					%>
						<a href="#" class="btn">수정</a>
						<a href="#" class="btn">삭제</a>
					<%
						}
					%>
						<a href="#" class="btn">이전글</a>
						<a href="#" class="btn">다음글</a>
						
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="/template/footer.jsp" flush="false"></jsp:include>
</body>
</html>











