<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
  //BoardDAO 클래스의 selectAll() 을 호출하여
    //DB에 들어있는 모든 글들을 list로 받아 오셔야 합니다.
    //리턴값으로 받은 리스트를 body태그에 반복문을 사용하여 하나씩 작성 (테이블 형식으로).
    //번호, 작성자, 제목, 비고(삭제)
    //조건문을 사용하여 DB에서 얻어온 글이 하나도 없을 때는
    //게시글이 존재하지 않는다 라는 글을 출력해 주세요.
    
    
    List<BoardVO> boardList = BoardDAO.getInstance().selectAll();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 목록</h2>
	<% if(boardList.size() > 0) {%>
	
	
	<table border="1">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>비고</th>
	</tr>
		<% for ( BoardVO vo : boardList)  { %>
			<tr>
				<td><%=vo.getBoardId() %></td>
				<td><%=vo.getWriter() %></td>
				<td>
				<a href="content.jsp?bId=<%=vo.getBoardId()%>"><%=vo.getTitle() %></a>
				</td>
				<td>
					<a href="delete.jsp?bId=<%=vo.getBoardId()%>">[삭제]</a>
				</td>
			</tr>
		<% } %>
	
	</table>
	
	<% } else { %>
		<h3>게시글이 존재하지 않습니다!</h3>
	<% } %>
	
	<br>
	
	<a href="write.jsp">새 글 작성하기</a>
	
	
	

</body>
</html>