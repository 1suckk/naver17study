<%@page import="Singleboard.data.SingleboardDto"%>
<%@page import="Singleboard.data.SingleboardDao"%>
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
		
		.tabboard th {
			background-color: orange; 
		}
		
		.btn {
			width: 100px;
		}
	</style>
</head>
<%
	//1. num
	int num = Integer.parseInt(request.getParameter("num"));
	//2. dao 선언
	SingleboardDao dao = new SingleboardDao();
	//3. dto 얻기
	SingleboardDto dto = new SingleboardDto();
%>
<body>
	<div style="margin: 30px; width: 400px">
		<form action="./updateaction.jsp" method="post">
			<!--  hidden -->
			<input type="hidden" name="num" value="<%=num %>">
			
			<table class="table table-bordered tabboard">
				<caption align="top">
					<h5><b>글수정</b></h5>
				</caption>
				<tr>
					<th width="100">작성자</th>
					<td>
						<input type="text" name="subject" class="form-control"
						required="required" value="<%=dto.getWriter() %>">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-sm btn-outline-secondary">
						글수정</button>
						
						<button type="button"
						class="btn btn-sm btn-outline-secondary"
						onclick="history.back()">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>