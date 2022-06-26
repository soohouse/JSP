<%@page import="user.UserRepository"%>
<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	User user = (User) session.getAttribute("login");
    
    	UserRepository.deleteUser(user.getAccount());
    	session.invalidate();   	
    %>
    
    <script>
    	alert("회원 탈퇴 처리되었습니다.");
    	location.href="login_form.jsp";
    </script>
    
    