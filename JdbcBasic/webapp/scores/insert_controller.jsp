<%@page import="kr.co.jsp.score.model.ScoreDAO"%>
<%@page import="kr.co.jsp.score.model.scoreVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	request.setCharacterEncoding("utf-8");
    
    	String name = request.getParameter("name");
    	int kor = Integer.parseInt(request.getParameter("kor"));
    	int eng = Integer.parseInt(request.getParameter("eng"));
    	int math = Integer.parseInt(request.getParameter("math"));
    	
    	int total = kor + eng + math;
    	double avg = total / 3.0;
    	
    	scoreVO vo = new scoreVO(0, name, kor, eng, math, total, avg);
    	
    	ScoreDAO dao = ScoreDAO.getInstance();
    	boolean flag = dao.insert(vo);
    	
    	if(flag) {
    		response.sendRedirect("insert_success.jsp");
    	} else {
    		response.sendRedirect("insert_form.jsp");
    	}

    %>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    