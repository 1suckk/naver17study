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
		
		.mycamera {
			font-size: 1.5em;
			cursor: pointer;
		}
		
		#myphoto {
			width: 200px;
			height: 200px;
			border: 1px solid gray;
			border-radius: 100px;
		}
	</style>
</head>
<body>
	<div style="margin: 50px;">
		<input type="file" id="photoupload" style="display: none">
		<img src="" id="myphoto" onerror="this.src='./image/noimage.png'" style="border-style: solid; border-radius: 50%;">
		<i class="bi bi-camera mycamera" style="border:1px solid black; border-radius: 100px; width: 200px; height: 200px;"></i>
		<script type="text/javascript">
			$(".mycamera").click(function(){
				$("#photoupload").trigger("click");
			});
			
			$("#photoupload").change(function(e){
				let form = new FormData();
				form.append("upload", $("#photoupload")[0].files[0]);//선택한 파일 한개
				
				/*
				processData:false : 서버에 전달하는 데이터는 query string이라는 형태로
				파일전송
				*/
				$.ajax({
					type:"post",
					dataType:"json",
					url:"./oneupload",
					processData:false,
					contentType:false,
					data:form,
					success:function(res){
						$("#myphoto").attr("src", "./save/"+res.photo);
					}
				});	
			});
		</script>
	</div>
</body>
</html>