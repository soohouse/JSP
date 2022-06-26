<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>회원 가입 양식</h2>
   
   <form action="register_controller.jsp" method="post">
      <p>
         <input type="text" name="account" placeholder="ID" required> <br>
         <input type="password" name="password" placeholder="PW"> <br>
         <input type="text" name="name" placeholder="이름"> <br>
         <input type="text" name="nickname" placeholder="별명"> <br>
         <input type="submit" value="회원가입">
      </p>
   </form>

</body>
</html>