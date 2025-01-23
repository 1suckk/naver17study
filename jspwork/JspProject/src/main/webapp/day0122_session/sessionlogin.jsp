<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body *{
                font-family: 'Jua';
            }
        </style>
       
    </head>

    <body>
    <%
    	//세션에 저장된 체크갑소가 아이디를 얻는다
    	//없을 경우 null값
    	String chksave = (String)session.getAttribute("chksave");
    	String myid = (String)session.getAttribute("myid");
    	
    	if(chksave == null)
    		myid="";
    %>
        <div class="login" style="margin: 30px;">
        	<form action="./loginaction.jsp" method="post">
	            <table class="table table-bordered" style="width: 300px;">
	                <tr>
	                    <td colspan="2" align="center">
	                        <label><input type="checkbox" name="chksave"
	                        <%=chksave==null?"":"checked" %>>아이디저장</label>
	                    </td>
	                </tr>
	                <tr>
	                    <th style="width: 100px;" class="table-info">아이디</th>
	                    <td>
	                        <input type="text" name="myid" class="form-control"
	                         placeholder="아이디" autofocus value="<%=myid%>">
	                    </td>
	                </tr>
	                <tr>
	                    <th style="width: 100px;" class="table-info">비밀번호</th>
	                    <td>
	                        <input type="password" name="mypass" class="form-control"
	                        placeholder="비밀번호">
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2" class="table-danger" align="center">
	                        <button type="submit" class="btn btn-default"
	                         style="width: 150px;">회원로그인</button>
	                    </td>
	                </tr>
	            </table>
	    	</form>        
        </div>
    </body>
</html>