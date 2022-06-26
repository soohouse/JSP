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
		# 아이디: ${sessionScope.user.id} <br>
		# 이름: ${user.name} <br>
		# 이메일: ${user.email} <br>
		# 주소: ${user.address}
	</p>

</body>
</html>