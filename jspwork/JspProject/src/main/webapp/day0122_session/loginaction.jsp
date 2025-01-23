<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String chksave = request.getParameter("chksave");
	String myid = request.getParameter("myid");
	String mypass = request.getParameter("mypass");
	
	if(myid.equals("angel") && mypass.equals("1234"))
	{
		if(chksave!=null){ //아이디 저장을 체크한 경우
			/*
			세션은 리다이렉트되어도 유지되는 속성이 있다
			*/
			session.setAttribute("myid", myid);
			session.setAttribute("chksave", "yes");
		}
		else //아이디저장을 체크안한 경우
		{
			//이전에 저장된 세션 삭제
			session.removeAttribute("chksave");
			session.removeAttribute("myid");
		}
		
		session.setAttribute("loginok", "yes");
		
		//유지시간 지정 (생략시 기본 30분간 유지)
		session.setMaxInactiveInterval(60*60); //한시간 유지
		
		response.sendRedirect("./sessionmain.jsp");//메인 페이지로 이동
	}
	
	else
	{%>
		<script type="text/javascript">
			alert("아이디와 비번이 맞지 않습니다");
			history.back();
		</script>
	<%}
%>