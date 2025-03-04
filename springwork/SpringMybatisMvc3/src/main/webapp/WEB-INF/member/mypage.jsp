<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 페이지</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<style>
		body *{
			font-family: 'Jua';
		}
		
		.profilelargephoto {
			width: 100px;
			height: 100px;
			border: 1px solid gray;
			border-radius: 100px;
		}
		
		.changecamera {
			
		}
	</style>
</head>
<body>
	<!-- The Modal -->
	<div class="modal" id="myUpdateModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">회원정보수정</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	      <!-- Modal body -->
	      <div class="modal-body">
	       	<h6>이름 수정</h6>
	        <input type="text" class="form-control" id="mname"
	        value="${dto.mname}">
	        <h6>전화번호 수정</h6>
	        <input type="text" class="form-control" id="mhp"
	        value="${dto.mhp}">
	        <h6>주소 수정</h6>
	        <input type="text" class="form-control" id="maddr"
	        value="${dto.maddr}">
	        <br>
	        <button type="button" class="btn btn-sm btn-danger"
	        id="btnupdate" data-bs-dismiss="modal">수정</button>
	        <!-- body에 들어갈 ajax -->
	        <script type="text/javascript">
	        	$("#btnupdate").click(function(){
	        		$.ajax({
	        			type:"post",
	        			dataType:"text",
	        			data:{"mname":$("#mname").val(), "mhp":$("#mhp").val(),
	        					"maddr":$("#maddr").val(),"num":${dto.num}},
	        			url:"/member/update",
	        			success:function(){
	        				location.reload();
	        			}
	        		});
	        	});
	        </script>
	      </div>
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- The Modal End -->
	
	<jsp:include page="../../layout/title.jsp"/>
	<div style="margin: 30px 100px;">
		<img src="${naverurl}/member/${dto.mphoto}" class="profilelargephoto"
		onerror="this.src='../save/noimage.png'" style="float: left;">
		
		<input type="file" id="fileupload" style="display: none">
		
		<i class="bi bi-camera-fill changecamera"></i>
		<script type="text/javascript">
			//카메라 버튼 클릭 시 
			//기존의 이미지는 대체되어야 함
			$(".changecamera").click(function(){
				$("#fileupload").trigger("click");
			});
			
			//사진변경 이벤트
			$("#fileupload").change(function(e){
				let form = 	new FormData();
				form.append("upload", e.target.files[0]);
				form.append("myid", "${dto.myid}");
			
				//ajax로 회원 프로필사진 수정
				$.ajax({
					type:"post",
					dataType:"text",
					data:form,
					url:"/member/changephoto",
					contentType: false,  // 필수 : x-www-form-urlencoded로 파싱되는 것을 방지
					processData: false,  // 필수: contentType을 false로 줬을 때 QueryString 자동 설정됨. 해제
					success:function(){
						location.reload();
					}
				});
			});
		</script>
	
		<div style="display: inline-block;margin: 20px 50px;">
			<table style="margin: 50px;">
				<tr>
					<th>
						회원명:&nbsp;&nbsp;
					</th>
					<td>
						${dto.mname}
					</td>
				</tr>
				<tr>
					<th>
						아이디:&nbsp;&nbsp;
					</th>
					<td>
						${dto.myid}
					</td>
				</tr>
				<tr>
					<th>
						주소:&nbsp;&nbsp;
					</th>
					<td>
						${dto.maddr}
					</td>
				</tr>
				<tr>
					<th>
						전화번호:&nbsp;&nbsp;
					</th>
					<td>
						${dto.mhp}
					</td>
				</tr>
				<tr>
					<th>
						가입일:&nbsp;&nbsp;
					</th>
					<td>
						<fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
			</table>
			<button type="button" class="btn btn-sm btn-danger"
			onclick="memdel(${dto.num})">
				회원탈퇴
			</button>
			<script type="text/javascript">
				function memdel(num)
				{
					let ans = confirm("정말 탈퇴를 하겠습니까?");
					if(ans)
					{
						$.ajax({
							type:"get",
							dataType:"text",
							data:{"num": num},
							url:"./mypagedel",
							success:function(){
								location.href="../";
							}
						});
					}
				}
			</script>
			
			<button type="button" class="btn btn-sm btn-success"
			data-bs-toggle="modal" data-bs-target="#myUpdateModal">
				회원수정
			</button>
		</div>

		<div style="margin: 20px 50px;">
			<table class="table table-striped table-bordered tabmyboard">
				<caption align="top">내가 쓴 글/답글</caption>
				<thead>
					<td>번호</td>
					<td>제목</td>
					<td>작성일</td>
					<td>조회수</td>
				</thead>
				
				<c:forEach var="bdto" items="${list}">
					<tbody>
						<td>${bdto.idx}</td>
						<td>
						<a href="../board/detail?idx=${bdto.idx}" style="color: black; text-decoration: none;">
							${bdto.subject}
						</a>
						</td>
						<td>${bdto.writeday}</td>
						<td>${bdto.readcount}</td>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>