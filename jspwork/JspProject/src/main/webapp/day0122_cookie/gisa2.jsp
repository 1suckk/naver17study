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
		도널드 트럼프 미국 대통령이 중국, 유럽연합(EU)에 대한 관세 부과에 나서는 동시에 미국 기업에 차별적인 국가에 대한
		보복 세금 부과를 시사하며 전선(戰線)을 넓히고 나섰다. 관세에 이어 세금 분야로 미국 우선주의 기조를 확대한 것으로,
		한국은 물론 국제 경제·통상 질서에 파장이 예상된다.
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