package kr.co.jsp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse responce) {
		
		List<BoardVO> boardList = BoardDAO.getInstance().listBoard();
		
		//1일 이내 신규글 new마크 처리 로직
		for(BoardVO vo : boardList) {
			//운영체제의 현재 시간을 읽어서 밀리초로 리턴하는 메서드
			//1970년 1월 1일 자정을 기준으로 현재까지 흐른 시간을 
			//밀리초로 리턴합니다.
			
			long now = System.currentTimeMillis();
			//게시물의 작성 시간을 밀리초로 읽어오기
			long regTime = vo.getRegDate().getTime();
			
			if(now - regTime < 60 * 60 * 24 * 1000) {
				vo.setNewMark(true);
			}
		}
		
		request.setAttribute("bList", boardList);

	}

}
