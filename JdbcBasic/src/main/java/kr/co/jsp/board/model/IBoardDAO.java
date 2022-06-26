package kr.co.jsp.board.model;

import java.util.List;

//interface는 멤버변수 선언이 불가함 목적이 객체생성이 아니기때문, 다형성의 장점을 갖기위해
	
public interface IBoardDAO {
	
	//게시글 등록
	boolean insert(BoardVO vo);
	
	//게시글 전체 조회
	List<BoardVO> selectAll();
	
	//게시글 상세 조회
	BoardVO selectOne(int bId);
	
	//게시글 수정
	boolean update(BoardVO vo);
	
	//게시글 삭제
	boolean delete(int bId);

}
