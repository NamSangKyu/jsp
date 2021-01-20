<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		String fileName = request.getParameter("file");
		String writer = request.getParameter("writer");
		String path = "c:\\fileupload\\"+writer + File.separator + fileName;
		//String path = fileName;
		File file = new File(path);
		System.out.println(file.toString());
		FileInputStream fis = new FileInputStream(path);
		String encodingName = URLEncoder.encode(path,"utf-8");
		
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		response.setHeader("Content-Transfer-Encoding","binary");
		response.setContentLength((int)file.length());
		
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buffer = new byte[1024*1024];
		
		while(true){
			int size = fis.read(buffer);
			if(size == -1) break;
			bos.write(buffer,0,size);
			bos.flush();
		}
		fis.close();
		bos.close();
	
	
	
	
	%>