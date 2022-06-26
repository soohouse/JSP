package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;

public class UpdateService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse responce) {
		
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BoardDAO.getInstance().updateBoard(title, content, bId);

	}

}
