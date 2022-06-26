<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    int age = Integer.parseInt(request.getParameter("age"));
    
   if(age >=20) {
	   //내장객체 response가 제공하는 sendRedirect()메서드를 통해
	   // 원하는 페이지로 강제 이동할 수 있습니다.
	   // 괄호 안에 이동시킬 페이지의 URL을 적어 주시면 됩니다.
	   response.sendRedirect("res_basic_ok.jsp");
   } else {
	   response.sendRedirect("res_basic_no.jsp");
   }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


</body>
</html>