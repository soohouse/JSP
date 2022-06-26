package kr.co.jsp.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUserService {
	
	void execute(HttpServletRequest request, HttpServletResponse response);
	//매개값으로는 request랑 response를 받아야한다


}
