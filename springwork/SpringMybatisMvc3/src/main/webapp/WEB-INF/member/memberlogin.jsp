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
	</style>
</head>
<body>
	<jsp:include page="../../layout/title.jsp" />
	<div style="margin: 10px 30px; width: 400px;">
		<!-- 로그인 form -->
		<form action="./login" method="post">
			<table class="table table-bordered tab1">
				<caption align="top">
					<b>로그인</b>
				</caption>
				<tbody>
					<tr>
						<th width="200">아이디</th>
						<td>
							<input type="text" name="myid" id="myid"
							required="required" class="form-control">
						</td>
					</tr>
					<tr>
						<th width="200">비밀번호</th>
						<td>
							<input type="password" name="mpass" id="mpass"
							required="required" class="form-control">
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="button" class="btn btn-sm btn-success" id="btnLogin">
							로그인</button>
							<button type="button" class="btn btn-sm btn-danger"
							onclick="location.href='./member/form'">
							회원가입</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

	<script type="text/javascript">
	 $(function() {
		//로그인 버튼 클릭 이벤트
		$("#btnLogin").click(function(){
			let myid = $("#myid").val(); //아이디 입력값 가져오기
			let mpass = $("#mpass").val(); //비밀번호 입력값 가져오기
			
			//아이디와 비밀번호가 하나라도 비어있는지 확인
			if(myid.trim()==="" || mpass.trim()==="")
			{
				alert("아이디와 비밀번호를 입력하세요!");
				return;
			}
			
			//ajax를 통해 로그인 요청 전송 (post, data: 부분은 myid와 mpass)
			$.ajax({
				type:"post",
				url:"/login",
				data: {
					myid:myid,
					mpass:mpass
				},
				dataType: "json",
				success: function(response) {
					console.log("서버 응답:", response); // 서버 응답 출력
                    if (response.result === "success")
                    {
                        alert("로그인 성공!");
                        location.href = "/"; // 로그인 성공 시 홈 페이지로 이동
                    }
                    else
                    {
                        alert("로그인 실패: ");
                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                	console.error("AJAX 오류:", textStatus, errorThrown); // 오류 정보 출력
                    alert("서버와의 통신 중 오류가 발생했습니다.");
                }
			});
		});
	 });
	</script>
</body>
</html>