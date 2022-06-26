<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    	# 요청 파라미터 (request parameter)
    	
    	- 클라이언트 측에서 서버로 데이터를 요청할 때 함께 전달되는 값들을
    	담은 변수를 요청 파라미터라고 합니다.
    	
    	- 요청 파라미터는 URL주소 뒤에 ?를 붙인 후에 [파라미터변수명=값]의
    	형식을 통해서 서버로 데이터를 전송합니다.
    	
    	- 요청 파라미터를 여러 개 전달할 때는 & 기호를 사용하여 나열해서 전달합니다.
     --%>
     
     <%
     	//클라이언트 쪽에서 전송된 요청 파라미터값을 읽는 방법.
     	String name = request.getParameter("name");
     	String age = request.getParameter("age");
     	String addr = request.getParameter("address");
     %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		이름: <%=name %> <br>
		나이: <%=age %>세 <br>
		주소: <%=addr %>
	</p>

</body>
</html>












