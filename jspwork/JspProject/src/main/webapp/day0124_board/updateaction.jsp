<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 자바빈즈를 잉요해서 처리하기 -->
<!--  useBean 으로 dao, dto 선언하고 setProperty 로 전체 데이터 읽기 -->
<jsp:useBean id="dao" class="Singleboard.data.SingleboardDao"/>
<jsp:useBean id="dto" class="Singleboard.data.SingleboardDto"/>
<hsp:setProperty property="*" name="dto" />

<%
	//dao의 updateBoard 호출
	dao.updateBoard(dto);
	//상세보기로 이동
	response.sendRedirect("./contentdetail.jsp?num"+dto.getNum());
%> 