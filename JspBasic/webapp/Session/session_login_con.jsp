<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% 
    	request.setCharacterEncoding("utf-8");
    
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String nick = request.getParameter("nick");
    	
    	if(id.equals("abc1234") && pw.equals("aaa1111")) {
    		session.setAttribute("user_id", id);
    		session.setAttribute("user_nick", nick);
    		response.sendRedirect("session_welcome.jsp");
    	} else {
    		
    %>
    
    <%--
    	HTML 내부에 자바스크립트 코드를 사용하려면 <script> 태그를 사용합니다.
    	- JS내장함수 alert()은 브라우저에 경고창을 띄웁니다.
    	()안에 띄우고 싶은 문구를 작성합니다.
    	- location.href="이동시킬 URL" == sendRedirect(URL)
    	- JS 내장객체 history가 제공하는 메서드인 back()은 뒤로가기 기능을 수행합니다.
    --%>
    
    <script>
    	alert("로그인에 실패했습니다.");
    	//history.back();
    	location.href="session_login.jsp";
    </script>
    
    <% } %>