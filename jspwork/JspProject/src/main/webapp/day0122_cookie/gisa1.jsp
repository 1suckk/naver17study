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
		for(int i=0; i<cookies.length; i++)
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
		도널드 트럼프 미국 대통령 취임 행사장 안팎에서는 예기치 못한 문제적 장면이 속출했다.
		정권 실세로 급부상한 일론 머스크 테슬라 최고경영자(CEO)는 청중을 향해 나치 경례 
		동작을 취해 비난받았고, 국방부는 트럼프 대통령과 앙숙 관계인 전직 장성의 초상화를 
		황급히 치워 '정치 보복' 우려를 키웠다. '트럼프 2기 미국'의 앞날을 상징적으로 
		보여주는 일종의 예고편이라는 평가가 나왔다.
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