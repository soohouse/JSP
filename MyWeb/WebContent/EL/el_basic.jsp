<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		<% int i = 5; %>
		
		<%= 10 * 4 %> <br> <!--  out.print(10*4); -->
		<%= 5.55 +3 %> <br>
		<%="안녕하세요~" %> <br>
		<%= i %>
	</p>
	
	<hr>
	
	<p>
		${ 10 * 4 } <br>
		${ 5.55 + 3 } <br>
		${'안녕하세요~' } <br>
		${i}
	</p>
	
</body>
</html>