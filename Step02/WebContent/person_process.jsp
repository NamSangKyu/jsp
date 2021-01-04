<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="obj.Person" %>
<%
	String name=request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));

	Person p = new Person(name,age);
	System.out.println(p.toString());
	
	request.setAttribute("obj", p);//키값 obj로 p 객체 저장
	//페이지 이동 1 - 이동할 페이지 경로, 응답 후 더이상 사용자의 요청을 받을 필요가 없을때
	//response.sendRedirect("person_result.jsp");
	//페이지 이동 2 - 계속해서 사용자의 응답을 받아야 될때
	RequestDispatcher dispatcher = request.getRequestDispatcher("person_result.jsp");
	dispatcher.forward(request, response);//페이지 이동 수행
%>
<!--  페이지 이동 1 - 사용자의 요청이 전부 초기화 
<script>
	location.href="person_result.jsp";
</script>
-->