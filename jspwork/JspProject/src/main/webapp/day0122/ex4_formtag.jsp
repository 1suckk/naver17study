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
	</style>
</head>
<body>
	<div style="margin: 30px">
		<form action="./ex4_action.jsp" method="post"><!-- method="" 생략시 디폴트로 get 적용 -->
			<table class="table table-bordered" style="width: 300px">
				<tr>
					<th width="100">아이디</th>
					<td>
						<input type="text" name="myid" class="form-control"
						required="required" value="angel">
					</td>
				</tr>
				<tr>
					<th width="100">비밀번호</th>
					<td>
						<input type="password" name="mypass" class="form-control"
						required="required" value="12345">
					</td>
				</tr>
				<tr>
					<th width="100">이름</th>
					<td>
						<input type="text" name="myname" class="form-control"
						required="required" value="채원석">
					</td>
				</tr>
				<tr>
					<th width="100">운전면허</th>
					<td>
						<label>
							<input type="checkbox" name="driver" class="form-control">운전면허
						</label>
					</td>
				</tr>
				<tr>
					<th width="100">주거지</th>
					<td>
						<label>
							<input type="radio" name="homeaddr" value="서울">서울
						</label>
						<label>
							<input type="radio" name="homeaddr" value="경기도">경기도
						</label>
						<label>
							<input type="radio" name="homeaddr" value="제주도">제주도
						</label>
						<label>
							<input type="radio" name="homeaddr" value="부산">부산
						</label>							
					</td>
				</tr>
				<tr>
					<th width="100">취미</th>
					<td>
						<label>
							<input type="checkbox" name="hobby" value="게임">게임
						</label>
						<label>
							<input type="checkbox" name="hobby" value="낚시">낚시
						</label>
						<label>
							<input type="checkbox" name="hobby" value="여행">여행
						</label>
						<label>
							<input type="checkbox" name="hobby" value="음악감상">음악감상
						</label>							
					</td>
				</tr>
				<tr>
				<tr>
					<th width="100">좋아하는음식</th>
					<td>
						<select type="form-select" name="myfood">
							<option value="2.jpg">닭꼬치</option>
							<option value="4.jpg">소고기카레</option>
							<option value="11.jpg">망고빙수</option>
							<option value="10.jpg">햄마요덮밥</option>
						</select>												
					</td>
				</tr>
				<tr>
					<th width="100">글자색</th>
					<td>
						<input type="color" name="fcolor" value="#ccffcc">											
					</td>
				</tr>
				<tr>
					<th width="100">생년월일</th>
					<td>
						<input type="date" name="mybirth" value="2010-01-01">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">서버에 전송</button>
					</td> 
				</tr>
			</table>
		</form>
	</div>
</body>
</html>