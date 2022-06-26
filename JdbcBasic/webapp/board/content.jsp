<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//요청과 함께 넘어오는 파라미터값(글 번호)을 얻어와서
    	//DAO의 selectOne() 호출하여 객체를 받아오세요.
    	//content.jsp & delete.jsp 구현해오기!!
    	// ???완성해오기~
    			
    	int bId = Integer.parseInt(request.getParameter("bId"));
    	BoardVO vo = BoardDAO.getInstance().selectOne(bId);
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><%=vo.getBoardId() %>번 게시물 내용</h1>
	<p>
		# 작성자: <%=vo.getWriter() %> <br>
		# 제목: <%=vo.getTitle() %> <br>
		# 내용: <br>
		<textarea rows="5" readonly><%=vo.getContent() %></textarea>
		# 작성일: <%=vo.getRegDate() %>
	</p>
	
	<a href="list.jsp">글 목록보기</a>
	<a href="modify.jsp?bId=<%=vo.getBoardId()%>">글 수정하기</a>

</body>
</html>