<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% for(int i=1; i<=5; i++) { %>
	<h2>이클립스 내부에서 jsp 문서 작성하기!</h2>
	<p>
		안녕하세요! 오늘은 5월 6일 금요일입니다. <br>
		지금은 jsp 문서를 작성 중이에요!
	</p>
	<% } %>
	
	<hr>
	
	<h2>구구단 4단</h2>
	<% for(int hang=1; hang<=9; hang++) { 
		//out.print()는 브라우저에 바로 출력을 실행하는 메서드입니다.
		//브라우저에 출력할 텍스트나 html 태그는 ""에 감싸서 전달하시고,
		//자바 변수나 메서드의 리턴값은 바로 작성하시면 되겠습니다.
		out.print("4 x " + hang + " = " + (4*hang) + "<br>");
	 } %>
	 
	 <!-- 
	 	반복문, 조건문을 사용하여 구구단을 홀수단 (3,5,7,9)만
	 	브라우저에 출력하기.
	 	(구구단 단 전체 범위: 2~9단)
	  -->
	  <h2>구구단 예제</h2>
	  <%
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++){
				if(i%2 ==1)
			out.print(i +"x" + j + "=" + i*j +"<br>");
		}
		}
	  
	  %>
	  
	  <!-- if(dan%2 !=0 -->
	 
	 

</body>
</html>