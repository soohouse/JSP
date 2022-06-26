<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>시험 점수 등록하기</h1>
	<form action="insert_controller.jsp" method="post">
		<p>
			# 이름: <input type="text" name="name" maxlength="5"> <br>
			# 국어: <input type="text" name="kor" maxlength="3"> <br>
			# 영어: <input type="text" name="eng" maxlength="3"> <br>
			# 수학: <input type="text" name="math" maxlength="3"> <br>
			<input type="submit" value="확인">
			
		</p>
	</form>

</body>
</html>