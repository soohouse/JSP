package kr.co.jsp.board.commons;

//사용자가 선택하는 페이지의 전반적인 정보를 담아놓을 클래스
public class PageVO {
	
	private int page;//사용자가 선택한 페이지 번호
	private int countPerPage;//한 화면에 보여질 게시물 수
	
	public PageVO() {
		page = 1;
		countPerPage = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	
	public String toString() {
		return "PageVO [ page=" + page + ", countPerPage=" + countPerPage + "]";
	}

}
