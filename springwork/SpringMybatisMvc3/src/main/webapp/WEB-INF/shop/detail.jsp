<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>세부 페이지</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<style>
		body *{
			font-family: 'Jua';
		}
		
		img.small {
			width: 80px;
			height: 120px;
		}
		
		img.large {
			width: 400px;
			height: 600px;
		}
		
		img.mini {
			width: 30px;
			height: 30px;
			border: 1px solid gray;
			margin-right: 10px;
			cursor: pointer;
		}
		
		span.day{
			color: #ccc;
			font-size: 0.9em;
			margin-left: 20px;
		}
		
		.likesicon {
			font-size: 18px;
			cursor: pointer;
			color: red;
		}
		
		span.chu {
			color: #999;
			font-size: 0.9em;
		}
		
		.repledel {
			color: red;
			cursor: pointer;
			font-size: 0.9em;
			margin-left: 10px;
		}
	</style>
	<script type="text/javascript">
		let file; //전역변수로 부여
		$(function(){
			replelist(); //처음 로딩 시 댓글 출력
			
			//카메라 업로드 이벤트
			$(".addphoto").click(function(){
				$("#photoupload").trigger("click");
			});
			
			//파일 업로드 이벤트
			$("#photoupload").change(function(e){
				file = e.target.files[0];
				//디버깅 콘솔
				console.log(file);
			});
			
			//댓글 등록 이벤트
			$("#btnaddreple").click(function(){
				//여기에는 세가지 반응이 있다
				//1. 글은 안올린 경우 --> 글을 입력하라고 alert
				//2. 사진은 안올린 경우 --> 사진을 입력하라고 alert
				let m = $("#message").val();
				if(m=='')
				{
					alert("댓글을 입력하세요.");
					return;
				}
				
				//''이 아니라 null인 이유는 
				if(file==null)
				{
					alert("사진을 선택하세요.");
					return;
				}
				let form = new FormData();
				console.log(file);
				form.append("upload", file); //댓글에 올릴 사진 업로드
				form.append("message", m); //댓글에 올릴 텍스트 메시지 업로드
				form.append("num", ${dto.num}); //몇번 글에 올릴지 추가
				
				$.ajax({
					type:"post",
					dataType:"text",
					url:"./addreple",
					data:form,
					contentType: false,  // 필수 : x-www-form-urlencoded로 파싱되는 것을 방지
					processData: false,  // 필수: contentType을 false로 줬을 때 QueryString 자동 설정됨. 해제
					success:function(){
						$("#message").val(""); //초기화
						file = null;
						replelist();
					}
				});
			});
			
			//미니 댓글 사진 클릭시 원본사진 보기
			$(document).on("click", "img.mini", function(){
				let imgSrc = $(this).attr("src");
				$("img.replelarge").attr("src", imgSrc);
			});
			
			//댓글 삭제
			$(document).on("click", ".repledel", function() {
				let idx = $(this).attr("idx");
				let ans=confirm("해당 댓글을 삭제할까요?");
				if(!ans) return;//취소 클릭시 함수 종료
				
				$.ajax({
					type:"get",
					dataType:"text",
					data:{"idx":idx},
					url:"./repledel",
					success:function(){
						//댓글 삭제 후 전체 댓글 다시 출력
						replelist();
					}
				});
			});
			
			//추천아이콘 클릭시 추천수 증가
			$(document).on("click", ".likesicon", function(){
				let idx = $(this).attr("idx");
				let icon = $(this);
				$.ajax({
					type:"get",
					dataType:"json",
					url:"./likes",
					data:{"idx":idx},
					success:function(res){
						//댓글 삭제 후 전체 댓글 다시 출력
						icon.next().find(".likes").text(res.likes); //추천 아이콘 옆의 숫자 변경 이벤트
					}
				});
			});	
		});
		
		function replelist()
		{
			$.ajax({
				type:"get",
				dataType:"json",
				url:"./replelist",
				data:{"num":${dto.num}},
				success:function(res){
					let s = "";
					
					$.each(res, function(idx, item){
						s+=
							`
							<div class="list" style="margin-bottom:5px;">
								<img src="${naverurl}/shop/\${item.photo}" class="mini"
								data-bs-toggle="modal" data-bs-target="#myMiniPhotoModal">
								\${item.message}
								<span class="day">\${item.writetime}</span>
								<span style:"float:right;">
									<i class="bi bi-hand-thumbs-up likesicon" idx="\${item.idx}"></i>
									<span class="chu">추천 <span class="likes">\${item.likes}</span></span>
									<i class="bi bi-x-lg repledel" idx="\${item.idx}"></i>
								</span>
							</div>
							`;
					});
					
					s+="</div>"; //왜 div 닫는 태그를 하나 더?
					$("div.replelist").html(s);
				}
			});
		}
	</script>
</head>
<body>
	<jsp:include page="../../layout/title.jsp" />
	<!-- The Modal -->
	<div class="modal" id="myMiniPhotoModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">원본사진</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <img src="" class="replelarge" style="width: 100%">
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">			
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div>
	
	    </div>
	  </div>
	</div>
	
	<table>
		<tr>
			<td>
				<c:forTokens var="photo" items="${dto.sphoto}" delims=",">
					<img src="${naverurl}/shop/${photo}" class="small"><br>
					<script type="text/javascript">
						$("img.small").click(function(){
							$("img.large").attr("src", $(this).attr("src"));
						});
					</script>
				</c:forTokens>
			</td>
			<td align="center">
				<img src="${naverurl}/shop/${dto.mainPhoto}" class="large"
				onerror="this.src='../save/noimage.png'">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<h6>상품명: ${dto.sangpum}</h6>
				<h6>가격: ${dto.sprice}원</h6>
				<h6>색상: ${dto.scolor}</h6>
				<h6>입고일: ${dto.ipgoday}</h6>
				<h6>등록일: <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/> </h6>
			</td>
			<br>
		</tr>
		<tr>
			<td colspan="2">
				<div class="repleform input-group" style="width: 600px;">
					<input type="text" id="message" class="form-control"
					style="width: 400px;" placeholder="댓글입력">
					<input type="file" id="photoupload" style="display:none">
					<i class="bi bi-camera-fill addphoto"></i>
					<button type="button" class="btn btn-sm btn-info" id="btnaddreple">등록</button>
				</div>
				
				<!-- 이번의 경우 사진과 댓글을 함께 실어야 한다
				사진만 실을 때는 바로 폼으로 보내면 되지만,
				사진과 댓글을 함께 보내야 하는 이번 경우는 사진을 바로 보내면 안된다
				그것에 참고해서 로직 작성할 것 -->
				<div class="replelist">
					
				</div>
			</td>
		</tr>		
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-sm btn-success"
				onclick="location.href='./addform'">상품등록</button>
				<button type="button" class="btn btn-sm btn-success"
				onclick="location.href='./list'">
				목록</button>
				<!--?num=${dto.num} 부분을 안써서 오류 발생 num이라는 parameter 
				찾지 못한다고 whitelabel error 발생해서 오랜 시간을 허비함-->
				<button type="button" class="btn btn-sm btn-success"
				onclick="location.href='./updateform?num=${dto.num}'">
				수정</button>
				<button type="button" class="btn btn-sm btn-success"
				onclick="sangdel(${dto.num})">
				삭제</button>
				
				<script type="text/javascript">
					function sangdel(num)
					{
						let ans = confirm("해당 게시물을 삭제하려면 [확인]을 눌러주세요");
						if(ans)
						{
							location.href="./delete?num="+num;
						}
					}
				</script>
				
				<button type="button" class="btn btn-sm btn-outline-secondary"
				style="width: 90px;"
				onclick="location.href='photos?num=${dto.num}'">
					사진수정
				</button>
			</td>
		</tr>
	</table>
</body>
</html>