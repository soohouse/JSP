<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	int bId = Integer.parseInt(request.getParameter("bId"));
    
    	if(BoardDAO.getInstance().delete(bId)) {
    %>
    
    	<script>
    		alert("삭제가 정상 처리되었습니다.");
    		location.href="list.jsp";
    	</script>
    	
    <% } else { %>
    	<Script>
	    	alert("삭제에 실패했습니다.");
			location.href="list.jsp";
    	</Script>
    <% } %>