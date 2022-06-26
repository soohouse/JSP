<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@page import="org.apache.coyote.Request"%>
<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    	<%
    	/*
    	   1. 파라미터값 얻어오기 (id, pw)
    	   2. DAO 주소값 얻어오기
    	   3. 로그인 유효성 검증 메서드 userCheck() 호출하기.
    	   - 아이디가 없다면 스크립트 경고창 출력 후 로그인 페이지로 이동 (-1)
    	   - 비밀번호가 틀렸다면 비밀번호가 틀렸다고 경고창 출력 후 뒤로가기 (0)
    	   - 로그인 성공일 경우 user_mypage.jsp로 리다이렉팅 (1)
    	   
    	   4. 로그인 성공 시 페이지 이동 전에 getUserInfo()를 호출하여
    	    로그인을 성공한 회원의 모든 정보를 받아와서 세션에 저장해 주세요.
    	   ( 세션 이름: user, 저장할 값: 로그인 성공한 회원의 UserVO 객체)
    	   */
    	   
    	   request.setCharacterEncoding("utf-8");
    	
    		String id = request.getParameter("id");
    		String pw = request.getParameter("pw");
    		
    		UserDAO dao = UserDAO.getInstance();
    		
    		int result = dao.usercheck(id, pw);
  
    		
    		if (result == -1) { %>
    		
    			<script>
    				alert("아이디가 존재하지 않습니다.");
    				location.href="user_login.jsp";
    			</script>		
    		<% } else if (result == 0 ) { %>
    			<script>
	    			alert("비밀번호가 틀렸습니다.");
	    			history.back();
    			</script>
    		<% } else { //로그인 성공
    			UserVO vo = dao.getUserInfo(id);
    			session.setAttribute("user", vo);
    			response.sendRedirect("user_mypage.jsp");
    		
    		}
    		%>