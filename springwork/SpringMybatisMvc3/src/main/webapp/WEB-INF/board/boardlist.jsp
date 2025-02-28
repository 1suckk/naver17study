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
	<jsp:include page="../../layout/title.jsp"/>
	
	<div style="margin: 20px; width: 700px;">
		<h5 class="alert alert-danger">
			총 ${totalCount} 개의 글이 있습니다.
			<button type="button" class="btn btn-sm btn-success"
			style="float: right;" onclick="location.href='./writeform'">
				글쓰기
			</button>
		</h5>
		<table class="tablist table table-borsered">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${totalCount==0}">
					<tr>
						<td colspan="5">
							등록된 글이 없습니다.
						</td>
					</tr>
				</c:if>
				<c:if test="${totalCount>0}">
					<c:forEach var="dto" items="${list}">
						<tr>
							<td>
								${no}
								<c:set var="no" value="${no-1}"/>
							</td>
							<td>
								<a href="./detail?idx=${dto.idx}&pageNum=${pageNum}"
									style="color: black; text-decoration: none;">
									<c:if test='${dto.relevel>0}'>
										<c:forEach begin="1" end="${dto.relevel}">
											&nbsp;&nbsp;&nbsp;
										</c:forEach>
										
										<img src="../save/re.png">
									</c:if>
									${dto.subject}
									
									<c:if test="${dto.photoCount==1}">
										<i class="bi bi-image picon"></i>
									</c:if>
									<c:if test="${dto.photoCount>1}">
										<i class="bi bi-images picon"></i>
									</c:if>
								</a>
							</td>
							<td>
								${dto.writer}
							</td>
							<td>
								<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/>
							</td>
							<td>
								${dto.readcount}
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<!-- 페이징 처리 -->
		<div style="width: 700px; text-align: center;">
			<ul class="pagination" style="margin-left: 200px; font-size: 0.8em">
				<c:if test="${startPage>1}">
					<li class="page-item">
						<a class="page-link" href="./list?pageNum=${startPage-1}">Prev</a>
					</li>
				</c:if>
				<c:forEach var="pp" begin="${startPage}" end="${endPage}">
					<c:if test="${pp==pageNum}">
						<li class="page-item active">
							<a class="page-link" href="./list?pageNum=${pp}">${pp}</a>
						</li>
					</c:if>
					<c:if test="${pp!=pageNum}">
						<li class="page-item">
							<a class="page-link" href="./list?pageNum=${pp}">${pp}</a>
						</li>
					</c:if>
					
				</c:forEach>
				<c:if test="${endPage<totalPage}">
					<li class="page-item">
						<a class="page-link" href="./list?pageNum=${endPage+1}">Next</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>