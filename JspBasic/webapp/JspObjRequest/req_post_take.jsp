<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    	//post방식을 통해 전달된 데이터의 한글 처리는 메서드를 사용하여 처리해야 합니다.
    	request.setCharacterEncoding("utf-8");
    
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String name = request.getParameter("name");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		# 아이디: <%=id %> <br>
		# 비밀번호: <%=pw %> <br>
		# 이름: <%=name %>
	
	</p>
	

</body>
</html>