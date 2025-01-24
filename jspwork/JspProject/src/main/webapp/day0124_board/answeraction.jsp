<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="adao" class="Singleboard.data.SingleAnswerDao"/>
<jsp:useBean id="adto" class="Singleboard.data.SingleAnswerDto"/>
<jsp:setProperty property="*" name="adto"/>

<%
	//댓글 삽입 이벤트
	adao.insertAnswer(adto);

	//상세보기 페이지로 이동
	response.sendRedirect("./contentdetail.jsp?num="+adto.getNum());
	
%>