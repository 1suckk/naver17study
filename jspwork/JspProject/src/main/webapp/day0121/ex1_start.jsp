<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>html, jsp 주석 확인</h3>
	
	<!-- 보이는 주석 -->
	<%-- 안보이는 주석 --%>
	
	<!--
	<script type="text/javascript">
		document.write("hello");
	</script>
	-->
	
	<%
		//선언문
		//이곳에 변수를 등록하면 서블릿 변환시 멤버변수로 등록된다
		String name = "채원석";
	
		//스크립트릿 (scriptlet) : 자바영역
		//이곳에서 선언하는 변수는 서블릿 변환시 지역변수로 등록된다 (doGet의 지역변수로)
		
		//변수를 브라우저에 출력하는 방법
		//1번째 
		out.print("<h2> h2 이름: " + name + "</h2>");
	%>
	
	<!-- 2번째 표현식을 이용한 자바 영역의 변수 출력 -->
	<h4> h4 이름: <%=name%></h4>
	
	<%
		String addr = "서울시 강남구 역삼동";
	%>
	
	<h5 style="color:blue;">주소 : <%=addr %></h5>
	
	<!-- 
	jsp 실행하면 servlet 파일으로 변환 => class 파일로 컴파일
	class 파일이 실행되서 브라우저로 나온다
	D:\naver17study\jspwork\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\
	Catalina\localhost\JspProject\org\apache\jsp
	 -->
	 
	 
	 
</body>
</html>