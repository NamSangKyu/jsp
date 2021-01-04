<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");

	//초단위 설정
	session.setMaxInactiveInterval(60*30); //30분
	
	if(id.equals("admin") && pass.equals("1234")){
		//로그인 성공 처리
		session.setAttribute("login", true);
		session.setAttribute("name", "관리자");
		session.removeAttribute("msg");
	}else{
		//로그인 실패 처리
		session.setAttribute("login", false);
		session.setAttribute("msg", "로그인에 실패하셨습니다. 아이디 비밀번호 확인하세요");
	}
	response.sendRedirect("login.jsp");	
%>






