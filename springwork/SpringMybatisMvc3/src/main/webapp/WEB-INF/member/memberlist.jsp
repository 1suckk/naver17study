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
	</style>
</head>
<body>
	<jsp:include page="../../layout/title.jsp" />
	<div style="margin: 20px; width: 700px;">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>
						<input type="checkbox" name="checkAll" id="chkAllSelect">&nbsp;회원명
					</th>
					<th>아이디</th>
					<th>핸드폰</th>
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
								<img src="${dto.mphoto}">
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
							<a href="./member/delete?num=${dto.num}">
								삭제
							</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">
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
			
			//선택한 회원 삭제 요청
			$.ajax({
				type:"post",
				url:"/member/deleteSelected",
				data:{selected:selected},
				success: function() {
					location.reload(); //회원 삭제 후 페이지 새로고침
				}	
			});
		});
	</script>
</body>
</html>