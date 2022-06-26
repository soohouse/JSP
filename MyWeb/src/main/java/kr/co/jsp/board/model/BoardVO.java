package kr.co.jsp.board.model;

import java.sql.Timestamp;

public class BoardVO {

	private int boardId;
	private String writer;
	private String title;
	private String content;
	private Timestamp regDate;
	private int hit;
	
	//new 마크를 띄울 지 말지의 여부를 판단하는 논리 필드 추가
	private boolean newMark;
	
	public BoardVO() {}
	
	
	public BoardVO(int boardId, String writer, String title, String content, Timestamp regDate, int hit) {
		super();
		this.boardId = boardId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Timestamp getRegDate() {
		return regDate;
	}


	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public void setNewMark(boolean newMark) {
		this.newMark = newMark;
	}
	
	public boolean isNewMark() {
		return newMark;
	}
	//boolean 타입의 get메서드는 is+멤버메서드로 해야함
	
}
