<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
		a.hover {
			color: hotpink;
		}
		
		ul.mymenu {
			list-style: none;
			margin: 10px;
			display: block;
		}
		
		ul.mymenu li {
			float: left;
			width: 100px;
			height: 40px;
			line-height: 40px;
			text-align: center;
			background-color: #ffe4e1;
			margin-right: 10px;
			border: 1px solid gray;
			border-radius: 20px;  
		}
		
		ul.mymenu li hover {
			background-color: #d3d3d3;
			box-shadow: 5px 5px 5px gray; 
		}
		
		img.profilephoto {
			width: 40px;
			height: 40px;
			border: 1px solid gray;
			margin-right: 10px;
			cursor: pointer;
		}
	</style>
</head>
<!-- 프로젝트 경로 구하기 - 절대경로를 위한 코드 -->
<!-- 사진의 경로가 다 달라진다 shop/list라든지 board/list 라든지 -->
<!-- 그래서 상대 주소 쓰기가 어려워짐! 절대 주소로 해야함 -->
<c:set var="root" value="${pageContext.request.contextPath}"/>
<body>
	<div style="margin: 10px;">
		<h2>
			<a href="${root}/" style="color: black;">
				<img src="${root}/image/macbook.jpg" width="50">
				공동구매 플랫폼 서비스, 비트공구
			</a>
		</h2>
		<ul class="mymenu">
			<li>
				<a href="${root}/">Home</a>
			</li>
			<li>
				<a href="${root}/naver/papago">파파고</a>
			</li>
			<li>
				<a href="${root}/shop/list">상품목록</a>
			</li>
			<c:if test="${sessionScope.loginstatus==null}">
				<li>
					<a href="${root}/member/form">회원가입</a>
				</li>
			</c:if>
			<c:if test="${sessionScope.loginstatus != null && sessionScope.loginUser.myid == 'admin'}">
			    <li>
			        <a href="${root}/member/list">회원목록</a>
			    </li>
			</c:if>
			<c:if test="${sessionScope.loginstatus != null}">
			    <li>
			        <a href="${root}/board/list">게시판</a>
			    </li>
			</c:if>
			<li>
				<c:if test="${sessionScope.loginstatus==null}">
					<a href="${root}/login">로그인</a>
				</c:if>
				<c:if test="${sessionScope.loginstatus!=null}">
					<a href="${root}/logout">로그아웃</a>
				</c:if>
			</li>
			<c:choose>
		        <c:when test="${sessionScope.loginstatus == null}">
		        </c:when>
		        <c:otherwise>
		        	<c:set var="naverurl" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-140"/>
		        	<img class="profilephoto" src="${naverurl}/member/${sessionScope.loginUser.mphoto}" class="profilephoto"
		        	onerror="this.src='/save/noimage.png'">
		        	<script type="text/javascript">
						//로그인 상태에서 회원 사진 클릭시 이벤트
						$(".profilephoto").click(function(){
							location.href='/member/mypage';
						});
					</script>
		            ${sessionScope.loginid}님이 로그인 중입니다
		        </c:otherwise>
   			</c:choose>
		</ul>
	</div>
	<hr style="clear: both;">
</body>
</html>