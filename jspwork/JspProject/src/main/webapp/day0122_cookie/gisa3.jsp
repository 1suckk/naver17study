<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<style>
		body *{
			font-family: 'Jua';
		}
	</style>
</head>
<%
	boolean blogin = false;
	
	Cookie[] cookies = request.getCookies();
	if(cookies!=null)
	{
		for(int i=0;i<cookies.length; i++)
		{
			if(cookies[i].getName().equals("loginok")) {
				blogin=true;
				break;
			}
		}
	}
%>
<body>
<%
	if(blogin){%>
	<pre>
		[파이낸셜뉴스] 취임 전부터 영토 확장 야욕을 드러낸 미국 도널드 트럼프 대통령이 본격적인 2기 정부 일정을 시작하면서 주변국들이 긴장하고 있다.
		파나마는 일단 유엔에 항의 서한을 보냈으며 그린란드는 미국령이 되지 않겠다고 재차 강조했다.
	</pre>
	<%}else{%>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요");
			history.back(); //이전 페이지로 이동
		</script>
	<%}
%>
</body>
</html>