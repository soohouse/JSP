<%@page import="java.text.Normalizer.Form"%>
<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%
    /*
   - 수정에 필요한 파라미터값을 불러와서 그것을 토대로
   BoardVO 객체를 생성하세요. (제목, 내용만 수정됩니다.)
   
   - BoardDAO의 update()를 이용하여 수정한 객체를 DB에 적용시켜 주시고
    결과가 성공이라면 해당 글 상세보기 페이지로 이동시켜 주세요.
    결과가 실패라면 list.jsp로 리다이렉팅 해주세요.
   */
   
   	request.setCharacterEncoding("utf-8");
	   
  	BoardVO vo = new BoardVO();
	vo.setBoardId(Integer.parseInt(request.getParameter("bId")));
	vo.setTitle(request.getParameter("title"));
	vo.setContent(request.getParameter("content"));
	
	if(BoardDAO.getInstance().update(vo)) {
		response.sendRedirect("content.jsp?bId=" + vo.getBoardId());
	} else {
		response.sendRedirect("list.jsp");
	}
	%>