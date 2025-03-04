<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 세부 페이지</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	
	<style>
		body *{
			font-family: 'Jua';
		}
		
		#boardDetailWriterProfile {
			width: 40px;
			height: 40px;
		}
		
		.tabform {
			table-layout:fixed;
       		width: 100%;
		}
		
		.tabform th{
			width: 100px;
			
		}
		
		#replewritephoto {
			width: 50px;
			height: 50px;
		}
		
		#addphoto {
			display: none;
		}
		
		.uploadphoto {
			font-size: 1.5em;
		}
		
		.profile {
			width: 40px;
			height: 40px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			replelist();
		});
		
		function replelist()
		{
			$.ajax({
     			type:"get",
     			dataType:"json",
     			data:{"idx":${dto.idx}},
     			url:"./replelist",
     			success:function(res){
     				let s="";
     				$.each(res,function(i,item){    					
     					s+=`
     						<img src="${naverurl}/member/\${item.profile}" class="profile">
     						<span>\${item.writer}</span>
     						<fmt:formatDate value="${item.writeday}" pattern="yyyy-MM-dd"/>
     						<div style="margin-left:20px;">
     							<pre style="font-size:15px;">\${item.message}</pre>
     							<br>
     						`; 
     					if(item.photo!=null)
						{	
         					s+=`<img src="${naverurl}/board/\${item.photo}" class="photo"><br><br>`;	
     					}
         				s+=`</div>`;
     				});
     				$(".replelist").html(s);
     			}
     		});
		}
		
		//댓글의 작은 사진을 클릭 ==> 원본 사진 모달로 나오게 하기
		$(document).on("click","img.photo",function(){
			//현재 사진 src 얻기
			let imgSrc=$(this).attr("src");
			//모달에 넣기
			$(".modalphoto").attr("src",imgSrc);
		});
	</script>
</head>
<body>
	<!-- The Modal -->
	<div class="modal" id="myRepleModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">회원 사진</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	      <!-- Modal body -->
	      <div class="modal-body">
	      	<img src="" class="modalphoto" style="max-width: 100%;">	
	      </div>
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- The Modal End -->
	<!-- 세션을 못받았다면, 즉 로그인을 안했다면 로그인 유도 -->
	<c:if test="${sessionScope.loginstatus==null}">
		<script type="text/javascript">
			alert("로그인을 먼저 진행하세요!");
			history.back();
		</script>
	</c:if>
	<jsp:include page="../../layout/title.jsp"/>
		<div style="margin: 30px; width: 700px;">
			<table class="tabform table table-bordered" style="margin:30px;">
				<caption align="top">
					<h5>${relevel==0?"[새글 세부 페이지]":"[답글 세부 페이지]"}</h5>
				</caption>
				<tbody>
					<tr>
						<th>제목</th>
						<td>
							${dto.subject}
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<img src="${naverurl}/member/${memberPhoto}" id="boardDetailWriterProfile"
							onerror="this.src='../save/noimage.png'">
							${dto.writer}
						</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>
							${dto.readcount}
						</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>
							<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td style="white-space: pre-line;">
							${dto.content}
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<c:forEach var="photo" items="${dto.photos}">
								<img src="${naverurl}/board/${photo}" style="max-width: 80px;">
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" onclick="history.back()">이전으로</button>
							<button type="button">글작성</button>
							<c:if test="${sessionScope.loginid.equals(dto.myid)}">
								<button type="button"
								onclick="location.href='./updateform?idx=${dto.idx}&pageNum=${pageNum}'">
									수정
								</button>
								<button type="button"
								onclick="boarddel()">
									삭제
								</button>
								<script type="text/javascript">
									function boarddel() {
										//삭제할지 물어보고 확인 누르면 삭제후 목록으로 이동
										let ans = confirm("해당 글을 삭제하겠습니까?");
										if(ans)
										{
											$.ajax({
												type:"get",
												dataType:"text",
												data:{"idx": ${dto.idx}},
												url:"./delete",
												success:function(){
													alert("삭제되었습니다.");
													location.href="./list?pageNum="+${pageNum};
												}
											});
										}
									}
								</script>
							</c:if>
							<button type="button"
								onclick="location.href='./writeform?idx=${dto.idx}&regroup=${dto.regroup}
								&restep=${dto.restep}&relevel=${dto.relevel}?pageNum=${pageNum}'">
								답글작성
							</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div style="margin: 30px;">
				<div class="replelist" style="width: 700px;"></div>
				<b>${writer}</b><br>
				<textarea id="message" class="form-control" rows="5" cols="82" placeholder="댓글을 남겨보세요"></textarea>
				<!-- 아래의 카메라 아이콘을 클릭할 때, 선택한 사진이 하나씩 나타나는 부분 -->
				<div class="replephoto" style="width: 700px;"></div>
				<i class="bi bi-camera-fill uploadphoto"></i>
				<input type="file" id="addphoto">
				<button type="button" class="btn btn-success btnreplesave" style="float: right">등록</button>
			</div>	
		</div>
		
		<!-- 카메라 클릭 시 파일 업로드와 삭제를 하나씩 진행되도록 -->
		<script type="text/javascript">
			//트리거 발생
			$(".uploadphoto").click(function(){
				$("#addphoto").trigger("click");
			});
			
			//사진 추가
			$("#addphoto").change(function(e){
				let form=new FormData();
				form.append("upload", e.target.files[0]);
				
				$.ajax({
					type:"post",
					dataType:"text",
					data:form,
					url:"/board/uploadreple",
					contentType: false,
					processData: false,
					success:function(res){
						$(".replephoto").html(
						`
						<img src="${naverurl}/board/\${res}" style="max-width: 50px; max-height: 50px;">
						<i class="bi bi-x-circle-fill replephotodel" fname="\${res}">
						`);
					}
				});
			});
			
			//사진 실시간 삭제
			$(document).on("click", ".replephotodel", function(){
				let close = $("this"); //x 아이콘
				let fname = close.attr("fname");
				$.ajax({
					type:"get",
					dataType:"text",
					data:{"fname":fname},
					url:"/board/repledel",
					success:function(){
						close.prev().remove(); //x 아이콘 좌측의 사진 삭제
						close.remove(); //사진 자신도 삭제
					}
				});
			});
			
			//댓글 저장
			$(".btnreplesave").click(function(){
				let idx=${dto.idx};
				let m=$("#message").val();
				
				$.ajax({
					type:"post",
					dataType:"text",
					data:{"idx":idx, "message":m},
					url:"/board/addreple",
					success:function(){
						//댓글 추가 이후 다시 댓글 입력창 초기화
						$("#message").val("");
						$(".replehoto").html("");
						alert("댓글이 저장되었습니다!");
						
						//다시 등록된 댓글 리스트 출력
						replelist();
					},
				    error: function(xhr, status, error) {
				        alert("댓글 저장 중 오류가 발생했습니다: " + error);
				    }
				});
			});
		</script>
</body>
</html>