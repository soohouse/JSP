<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    	//주소를 치고 강제로 들어오는 접근을 막겠습니다.
    	if(session.getAttribute("user") == null) { 
    		<script>
	    		alert("로그인 한 회원만 접근이 가능합니다.");
	    		location.href="user_login.jsp";
	    	</script>
   } else {
	   		UserVO vo = (UserVO) session.getAttribute("user"); --%>
   
   
   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="../include/header.jsp" %>
	
	<div align ="center">
		<h2>My Page</h2>
		<hr>
		<p>
			<strong>${user.name}(${user.id})님의 정보를 관리합니다.</strong>
		</p>
		<hr>
		<br>
		<p>
			<a href="/MyWeb/pwPage.user">비밀번호 변경</a> &nbsp;
			<a href="/MyWeb/modPage.user">회원정보 변경</a> &nbsp;
			<a href="/MyWeb/delPage.user">회원 탈퇴</a>
		</p>
	</div>
	
	<%@ include file="../include/footer.jsp" %>
	
</body>
</html>
