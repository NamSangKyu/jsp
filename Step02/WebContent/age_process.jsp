<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int age = Integer.parseInt(request.getParameter("age"));

	String path = "";
	if(age >= 20)
		path = "age_result_1.jsp";
	else
		path = "age_result_2.jsp";
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	dispatcher.forward(request, response);
	
	request.getRequestDispatcher(path).forward(request, response);
	
%>