<%@page import="dao.BoardDAO"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int mode = Integer.parseInt(request.getParameter("mode"));
	int bno = Integer.parseInt(request.getParameter("bno"));
	BoardDAO.getInstance().addLikeHate(bno,mode);
	int count = BoardDAO.getInstance().selectLikeHate(bno,mode);
	out.write(String.valueOf(count));    
%>