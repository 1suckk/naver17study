<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//loginok 가 존재한다면 현재 로그인 중 / 없으면 로그아웃 상태
	String loginok = (String)session.getAttribute("loginok");
%>

<body>
<%
	if(loginok == null)
	{%>
		<jsp:include page="./sessionlogin.jsp"/>
	<%}
	else
	{%>
		<jsp:include page="./sessionlogout.jsp"/>
	<%}

%>
</body>
</html>