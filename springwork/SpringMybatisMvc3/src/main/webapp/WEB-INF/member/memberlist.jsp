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

	<div style="margin: 20px; width: 500px;">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>
						<input type="checkbox" name="checkAll" id="chkAllSelect">&nbsp;회원명
					</th>
					<th>아이디</th>
					<th>핸드폰</th>
					<th>주소</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="dto" items="${list}">
						<td>
							<label>
								<img src="${dto.mphoto}">
								<input type="checkbox" name="memberchk" id="chkselect">&nbsp;${dto.mname}
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
						<td>
							<a href="./member/delete?num=${dto.num}">
								삭제
							</a>
						</td>
					</c:forEach>
				</tr>
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
		
	</div>
	<script type="text/javascript">
		$("input[name=checkAll]").click(function(){
			if($(this).is(":checked") === true)
				$("#chkselect").prop("checked", true);
			else
				$("#chkselect").prop("checked", false);
		});
	</script>
</body>
</html>