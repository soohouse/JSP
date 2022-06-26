package kr.co.jsp.board.model;

import java.util.List;

import javax.swing.text.AbstractDocument.Content;

public interface IBoardDAO {
	
	//sql문을 예상해보고 풀자
	
	//글 등록 메서드
	void regist(String writer, String title, String content);
	// 회원가입메서드랑 같음 알려줄필요가없음 무조건 등록. 실패하더라도 이유 안궁금
	
	//글 전체 목록을 가지고 오는 메서드
	List<BoardVO> listBoard();
	//()->매개값. 지금은 필요없음.
	
	//글 상세보기 요청을 처리할 메서드
	BoardVO contentBoard(int bId);
	//글 하나 가져올거라 포장해올 필요 x
	
	//글 수정 요청을 처리할 메서드(제목, 내용)
	void updateBoard(String title, String content, int bId);
	//여기도 결과를 보낼게 아니라 void, 따로 안보내고 묶어서 BoardVO vo로 보내도됌
	
	//글 삭제 요청을 처리할 메서드
	void deleteBoard(int bId);
	
	//조회수를 올려주는 메서드
	void upHit(int bId);
	
	//Update my_board SET hit = hit + 1 WHERE board_id=?
	
	//총 게시물 수를 알려주는 메서드
	int countArticles();


}
