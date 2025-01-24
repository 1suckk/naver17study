<%@page import="Singleboard.data.SingleboardDao"%>
<%@page import="Singleboard.data.SingleboardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//1. form 데이터 읽기
	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	//2. dto 선언후 데이터 넣기(생성자로)
	SingleboardDto dto = new SingleboardDto(writer, subject, content);
	
	//3. dao 선언
	SingleboardDao dao = new SingleboardDao();
	
	//4. insert 메서드 호출
	dao.insertBoard(dto);
	
	//5. boardlist.jsp로 이동
	response.sendRedirect("./boardlist.jsp");
%>    
    
    