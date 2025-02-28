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
	
	<!-- 로그인 안할 경우 작성 폼에 못 들어가요 -->
	<c:if test="${sessionScope.loginstatus==null}">
		<script type="text/javascript">
			alert("로그인을 먼저 해주세요\n먼저 로그인을 해주세요");
			history.back();
		</script>
	</c:if>
	
	<jsp:include page="../../layout/title.jsp"/>
	<div style="margin: 20px; width: 600px;">
		<form action="./insert" method="post" enctype="multipart/form-data">
			<!-- hidden -->
			<input type="hidden" name="idx" value="${idx}">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="regroup" value="${regroup}">
			<input type="hidden" name="restep" value="${restep}">
			<input type="hidden" name="relevel" value="${relevel}">
			
			<table class="tabform table table-bordered">
				<caption align="top">
					<h5>${relevel==0?"[새글 작성하기]":"[답글 작성하기]"}</h5>
				</caption>
				<tbody>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="subject" class="form-control"
							required="required" autofocus="autofocus">
						</td>
					</tr>
					<tr>
						<th>사진</th>
						<td>
							<input type="file" name="upload" class="form-contol"
							multiple="multiple">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="content" class="form-control"
							required="required" style="width: 100%; height: 150px;"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" class="btn btn-secondary" onclick="./insert">글저장</button>
							<button type="submit" onclick="history.back()">이전으로</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>