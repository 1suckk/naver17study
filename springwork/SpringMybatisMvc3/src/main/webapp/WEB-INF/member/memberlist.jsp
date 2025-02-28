<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 목록 페이지</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<style>
		body *{
			font-family: 'Jua';
		}
		
		.memberbox img {
			width: 100px;
			height: 100px;
		}
	</style>
</head>
<body>
	<jsp:include page="../../layout/title.jsp" />
	<div style="margin: 20px; width: 800px;" class="memberbox">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th style="width: 200px;">
						<input type="checkbox" name="checkAll" id="chkAllSelect">&nbsp;회원명
					</th>
					<th style="width: 100px;">아이디</th>
					<th style="widows: 150px;">핸드폰</th>
					<th>주소</th>
					<th>가입일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>
							<label>
								<img src="${fronturl}/member/${dto.mphoto}${backurl}"
								onerror="this.src='../save/noimage.png'">
								<input type="checkbox" name="memberchk" class="chkselect" value="${dto.num}">&nbsp;${dto.mname}
							</label>
						</td>
						<td>
							${dto.myid}
						</td>
						<td>
							${dto.mhp}
						</td>
						<td>
							${dto.maddr}
						</td>
						<td style="width:200px;">
							<fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd"/>
						</td>
						<td>
							<button type="button" class="btn btn-danger btn-sm btndelete" data-num="${dto.num}">
								삭제
							</button>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6">
						<button type="button" id="btnSelectedDel"
						style="float: left">
							선택한 회원 삭제
						</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$("input[name=checkAll]").click(function(){
			if($(this).is(":checked"))
				$(".chkselect").prop("checked", true);
			else
				$(".chkselect").prop("checked", false);
		});
		
		//선택한 회원 삭제 기능
		$("#btnSelectedDel").click(function(){
			let selected = [];
			$(".chkselect:checked").each(function(){
				selected.push($(this).val()); //선택한 회원의 값을 배열에 추가
			});
			
			if(selected.length === 0)
			{
				alert("삭제할 회원을 선택하세요.");
				return;
			}
			//관리자에게 삭제 전 경고
			if (confirm("정말로 삭제하시겠습니까? 삭제 후 번복은 불가합니다."))
			{
				//선택한 회원 삭제 요청
				$.ajax({
					type:"post",
					url:"/member/deleteSelected",
					data:{selected:selected},
					success: function() {
						location.reload(); //회원 삭제 후 페이지 새로고침
					}	
				});
			}
		});
		
		//개별 회원 삭제 기능
		$(".btndelete").click(function(){
			//data() 함수로 받아오기
			let num = $(this).data("num");
			//관리자에게 삭제 전 경고
			if (confirm("정말로 삭제하시겠습니까?"))
			{
	            $.ajax({
	                type: "post",
	                url: "/member/delete", // 개별 회원 삭제를 처리할 URL
	                data: { num: num }, // 삭제할 회원의 num 값 전송
	                success: function()
	                {
	                    location.reload(); // 삭제 후 페이지 새로고침
	                }
	            });
        	}
		});
	</script>
</body>
</html>