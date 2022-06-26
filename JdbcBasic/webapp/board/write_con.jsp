<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    <%
    /*
    1. 사용자의 입력값을 가져오세요. 그리고 객체로 포장하세요.
    2. DAO클래스의 주소값을 받아 DB에 내용을 삽입하는 메서드를 호출하세요.
    (board_id -> 시퀀스 객체로 삽입, 날짜는 넣어줄 필요가 없다.)
    3. 글 등록 성공 시 list.jsp로 리다이렉팅,
    4. 글 등록 실패 시 write.jsp로 리다이렉팅 해 주세요.
    */
    
    request.setCharacterEncoding("utf-8");
    
    /*
    BoardVO vo = new BoardVO(
    			0,
    			request.getParameter("writer"),
    			request.getParameter("title"),
    			request.getParameter("content"),
    			null
    		);
    */
    
    BoardVO vo = new BoardVO();
    vo.setWriter(request.getParameter("writer"));
    vo.setTitle(request.getParameter("title"));
    vo.setContent(request.getParameter("content"));
    
    if(BoardDAO.getInstance().insert(vo)) {
    	response.sendRedirect("list.jsp");
    } else {
    	response.sendRedirect("write.jsp");
    }
    
    //String writer = request.getParameter("writer");
    //String title = request.getParameter("title");
    //String content = request.getParameter("content");
    

    
    
    %>
    