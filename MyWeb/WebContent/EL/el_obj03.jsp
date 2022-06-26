<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		UserVO vo = (UserVO) session.getAttribute("member");
	%>
	
	<p>
		# 이름: <%=vo.getName() %> <br>
		# 아이디: <%=vo.getId() %> <br>
		# 이메일: <%=vo.getEmail()%> <br>
		# 주소: <%=vo.getAddress() %>
	</p>
	
	<hr>
	
	<%-- 변수명만 쓴다 --%>
	<p> 
		# 이름: ${sessionScope.member.name} <br> 
		# 아이디: ${member.id } <br>
		# 이메일: ${member.email} <br>
		# 주소: ${member.address}
	</p>

</body>
</html>