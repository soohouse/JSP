<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%
		UserVO vo = new UserVO(
					request.getParameter("id"),
					request.getParameter("pw"),
					request.getParameter("name"),
					request.getParameter("email"),
					request.getParameter("address")
				);
		session.setAttribute("member", vo);
	%>
	
	<a href="el_obj03.jsp">el로 세션 내의 객체의 값을 표현하기</a>