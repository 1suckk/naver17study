<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//한글깨짐 현상 예방
	request.setCharacterEncoding("utf-8");
	
	String myid = request.getParameter("myid");
	String mypass = request.getParameter("mypass");
	String myname = request.getParameter("myname");
	String driver = request.getParameter("driver");
	String homeaddr = request.getParameter("homeaddr");
	String myfood = request.getParameter("myfood");
	String fcolor = request.getParameter("fcolor");
	String mybirth = request.getParameter("mybirth");
	
	String[] hobby = request.getParameterValues("hobby");
%>
<body>
	<div style="font-size: 20px; color: <%=fcolor%>">
		아이디: <%=myid %><br>
		비밀번호: <%=mypass %><br>
		이름: <%=myname %><br>
		<!-- 이경우는 null일 경우 NullPointerException 이 발생한다 -->
		<!-- 값에 null이 들어올 확률이 있을 경우 무조건 조건은 null로 해야 한다 -->
		운전면허: <%=driver %> : (<%=driver==null?"없음":"있음" %>)<br>
		주거지: <%=homeaddr %><br>
		
		취미: 
		<%
		if (hobby==null){
			out.print("<b>없음</b>");
		}else {
			String s = "나의 취미는";
			for (String h:hobby)
				s+="["+h+"]";
			s+="입니다";
			%>
			<b><%=s%></b><br>
		<%}
		%>
		
		좋아하는 음식 : <img src="../image/food/<%=myfood %>" width="100" height="100"
					border="1"><br>
		글자색: <%=fcolor %><br>
		생년월일: <%=mybirth %><br>
	</div>
</body>
</html>