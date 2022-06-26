package kr.co.jsp.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.service.ChangePwService;
import kr.co.jsp.user.service.DeleteService;
import kr.co.jsp.user.service.IUserService;
import kr.co.jsp.user.service.JoinService;
import kr.co.jsp.user.service.LoginService;
import kr.co.jsp.user.service.UpdateService;


@WebServlet({ "/UserController", "*.user" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher dp;
	private IUserService sv;
       
    
    public UserController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response); //request로 불러오기
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post니까 utf-8부터 지정
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모든 요청이 doRequest로 몰릴 수 있다
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length()+1, uri.lastIndexOf("."));
		
		System.out.println(uri);
		
		switch(uri) {
		
		case "joinPage":
			System.out.println("회원가입 페이지로 이동 요청!");
			response.sendRedirect("/MyWeb/user_join.jsp");
			break;
			
		case "join":
			System.out.println("회원 가입 요청이 들어옴!");
			sv = new JoinService();
			sv.execute(request, response);
			break;
			//joinservice에서 응답 다 줘서 여기서 따로 줄 필요가 없다
		
		case "loginPage":
			System.out.println("로그인 페이지로 이동 요청!");
			response.sendRedirect(uri);
			
		case "login":
			System.out.println("로그인 요청이 들어옴!");
			sv = new LoginService();
			sv.execute(request, response);
			break;
			
		case "mypage":
			System.out.println("마이페이지로 이동 요청!");
			response.sendRedirect("user/user_mypage.jsp");
			break;
			
		case "pwPage":
			System.out.println("비밀번호 변경페이지로 이동 요청!");
			response.sendRedirect("user/user_change_pw.jsp");
			break;
			
		case "change_pw":
			System.out.println("비밀번호 변경 요청이 들어옴!");
			sv = new ChangePwService();
			sv.execute(request, response);
			break;
			
		case "modPage":
			System.out.println("회원정보 변경 페이지로 이동 요청!");
			response.sendRedirect("user/user_update.jsp");
			break;
			
		case "update":
			System.out.println("회원정보 수정 요청이 들어옴!");
			sv = new UpdateService();
			sv.execute(request, response);
			break;
			
		case "delPage":
			System.out.println("탈퇴 페이지로 이동 요청!");
			response.sendRedirect("user/user_delete.jsp");
			break;
			
		case "delete":
			System.out.println("탈퇴 요청이 들어옴!");
			sv = new DeleteService();
			sv.execute(request, response);
			break;
			
		}
	}

}
