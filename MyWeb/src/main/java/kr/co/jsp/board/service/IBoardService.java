package kr.co.jsp.board.service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 서비스 객체가 하나의 인터페이스 타입으로 객체를 생성할 수 있게,
//같은 이름의 메서드로 동작할 수 있게끔 인터페이스를 제작.
public interface IBoardService {
	
	//추상 메서드 선언!
	void execute(HttpServletRequest request, HttpServletResponse responce);

}
