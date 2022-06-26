<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String title = request.getParameter("title");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% if(title.equals("sel1")) { %>
		<div align="center">
		<h2>
		선택하신 앨범 정보
		</h2>
		<hr>
		<p>
			당신이 선택하신 영화는 오세훈의 <strong>해적:도깨비 깃발</strong>입니다.
		<hr>
		</p>
		<h3>영화 예고편</h3>
		<ifram width="1280 height="720" src="https://tv.naver.com/v/245185619?autoplay=1" title="Youtube">
		</div>
	<% } else if(title.equals("sel2")) { %>
		<div align="center">
		<h2>
		선택하신 앨범 정보
		</h2>
		<hr>
		<p>
		당신이 선택하신 영화는 공명의 <strong>행복의 진수</strong>입니다.
		</p>
		<hr>
		<h3>영화 예고편</h3>
		<video src="https://tv.naver.com/v/9253459"></video>
		</div>
	<% } %>




</body>
</html>