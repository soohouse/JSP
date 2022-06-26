package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;

public class RegistService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse responce) {
		
		String writer = request.getParameter("bWriter");
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		BoardDAO.getInstance().regist(writer, title, content);

	}

}
