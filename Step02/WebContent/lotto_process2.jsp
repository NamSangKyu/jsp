<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	boolean checkNumber(int arr[], int n){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==n) 
				return false;
		}
		return true;
	}
%>
<%
	//개수 입력
	int ea = Integer.parseInt(request.getParameter("ea"));
	//로또 번호를 생성
	Random r = new Random();
	HashSet<Integer> set = new HashSet<Integer>();
	String result = "<table>";
	for(int i=0;i<ea;i++){
		while(set.size()<6)
			set.add(r.nextInt(45)+1);
		//System.out.println(set);
		String[] str = set.toString().replace("[", "").
				replace("]", "").replaceAll(" ", "").split(",");
		result += "<tr>";
		for(String n : str){
			result += "<td>"+n+"</td>";
		}
		result += "</tr>";
		set.clear();
	}
	result += "</table>";
	request.setAttribute("result", result);
	request.getRequestDispatcher("lotto_result2.jsp").forward(request, response);
%>






