<%@page import="kr.co.jsp.board.commons.PageVO"%>
<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		for(int i=1; i<300; i++) {
			String writer = "김테스트" + i;
			String title = "테스트입니다." + i;
			String content = "테스트 중이니까 조용히 하세요!" + i;
			BoardDAO.getInstance().regist(writer, title, content);
		}
	
		out.print("insert 완료!");
	--%>
	
	<%
		out.print("----------------------------<br>");
		out.print("# 총 게시물 수: " + BoardDAO.getInstance().countArticles() + "<br>");
		out.print("----------------------------<br>");
		
		//끝 페이지 번호 계산 테스트
		PageVO paging = new PageVO();
		paging.setPage(31);
		paging.setCountPerPage(10);
		int displayBtn = 10;
		
		int endPage = (int) Math.ceil(paging.getPage() / (double)displayBtn) * displayBtn;
		out.print("끝 페이지 번호: " + endPage + "번<br>");
		
		//시작 페이지 번호 계산 테스트
		int beginPage = (endPage - displayBtn) + 1;
		out.print("시작 페이지 번호: " + beginPage + "번<br>");
		
		//이전버튼 활성, 비활성 여부
		boolean isPrev = (beginPage == 1) ? false : true;
		out.print("이전 버튼 활성화 여부: " + isPrev + "<br>");
		
		//다음 버튼 활성화 여부
		boolean isNext = (BoardDAO.getInstance().countArticles() <= (endPage * paging.getCountPerPage())) ? false : true;
		out.print("다음 버튼 활성화 여부: " + isNext + "<br>");
		
		//끝 페이지 보정
		if(!isNext) {//isNext == false
			endPage = (int) Math.ceil(BoardDAO.getInstance().countArticles()/(double) paging.getCountPerPage());
		}
		out.print("보정 후 끝 페이지 번호: " + endPage + "번");
	%>

</body>
</html>