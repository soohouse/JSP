<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		//# 쿠키 생성 방법
		//1. 쿠키 객체를 생성 - 생성자의 매개값으로 쿠키의 이름과 저장할 데이터를 입력하세요.
		
		String id = "abc1234";
	
		Cookie idCoo = new Cookie("id_cookie", id);
		Cookie nameCoo = new Cookie("name_cookie", "홍길동");
		
		//2. 쿠키 클래스의 setter 메서드로 쿠키의 속성을 설정.
		nameCoo.setMaxAge(60*60*24); //수명(쿠키의 유효시간 설정(초))을 꼭 적어줘야하며 1시간 -> 60*60
		idCoo.setMaxAge(20);
		
		//3. http 응답 시 reponse객체에 생성된 쿠키를 탑재하여 클라이언트로 전송.
		response.addCookie(nameCoo);
		response.addCookie(idCoo);
	%>
	
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="cookie_check.jsp">만든 쿠키 확인하기!</a>

</body>
</html>