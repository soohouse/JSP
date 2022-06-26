package kr.co.jsp.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse responce) {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		/*
	       # 쿠키로 조회수를 컨트롤 해 보자.
	       1. 사용자가 글 제목을 눌러서 상세보기 요청을 보낼 때 
	       글 번호로 된 쿠키를 하나 만들어 줄 겁니다. (String)
	       -getparameter로 새로 받아주세요
	       쿠키 이름과 쿠키에 저장할 값을 모두 글 번호로 만들어 주겠습니다.
	       
	       2. 요청을 보낼 때 같이 넘어온 쿠키 중에, 
	        현재 글 번호와 일치하는 쿠키가 존재한다면 조회수를 올려주지 않을 겁니다.
	        현재 글 번호와 일치하는 쿠키가 없다면 조회수를 올려주도록 하겠습니다.
	        쿠키의 수명은 15초로 설정하겠습니다.
	       */
		
		String bNum = request.getParameter("bId");
		
		/*
		Cookie hitCoo = new Cookie(bNum, bNum);
		hitCoo.setMaxAge(15);
		responce.addCookie(hitCoo);
		*/
		
		boolean flag = false;
		Cookie[] cookies = request.getCookies();//모든 쿠키를 다 싸그리 받아오자
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(bNum)) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				Cookie hitCoo = new Cookie(bNum, bNum);
				hitCoo.setMaxAge(15);
				responce.addCookie(hitCoo);//쿠키가존재하지않을때만 쿠키생성함 새고했을 때 15초뒤에는 무조건 올라감
				BoardDAO.getInstance().upHit(bId);
			}
		}
		
		BoardVO vo = BoardDAO.getInstance().contentBoard(bId);
		request.setAttribute("content", vo);

	}

}
