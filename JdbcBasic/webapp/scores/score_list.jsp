<%@page import="kr.co.jsp.score.model.scoreVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.jsp.score.model.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//DB테이블에 존재하는 모든 학생의 점수를 현재 jsp 파일로 가지고 와서
    	//테이블 태그로 출력하기
    	ScoreDAO dao = ScoreDAO.getInstance();
    	List<scoreVO> scoreList = dao.selectAll();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생들의 전체 성적 조회</h1>
	
	<form action="search.jsp">
		검색: <input type="text" name="keyword" placeholder="검색어를 입력하세요">
		<input type="submit" value="검색">
	</form>
	
	<table border ="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>비고</th>
		</tr>
		
		<% for(scoreVO vo : scoreList) { %>
			<tr>
				<td><%=vo.getId()%></td>
				<td><%=vo.getName() %></td>
				<td><%=vo.getKor() %></td>
				<td><%=vo.getEng() %></td>
				<td><%=vo.getMath() %></td>
				<td><%=vo.getTotal() %></td>
				<td><%=vo.getAverage() %></td>
				<td>
					<a href="delete.jsp?id=<%=vo.getId()%>">[삭제]</a>
				</td>
			</tr>
		<% } %>
	</table>
	
	<br>
	
	<a href="insert_from.jsp">새로운 점수 등록하기</a>
</body>
</html>