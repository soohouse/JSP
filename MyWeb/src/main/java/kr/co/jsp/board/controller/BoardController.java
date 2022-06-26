package kr.co.jsp.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;
import kr.co.jsp.board.service.ContentService;
import kr.co.jsp.board.service.GetListService;
import kr.co.jsp.board.service.IBoardService;
import kr.co.jsp.board.service.ModifyService;
import kr.co.jsp.board.service.RegistService;
import kr.co.jsp.board.service.UpdateService;


@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RequestDispatcher dp;
	private IBoardService sv;
    
    public BoardController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		uri = uri.substring(conPath.length() +1, uri.lastIndexOf("."));
		
		System.out.println(uri);
		
		switch (uri) {
		
		case "write" : 
			System.out.println("글쓰기 페이지로 이동 요청!");
			response.sendRedirect("board/board_write.jsp");
			break;
			
			
		case "regist" :
			System.out.println("글 등록 요청이 들어옴!");
			sv = new RegistService();
			sv.execute(request,response);
			//regist 메서드를 불러오세요
			
			/*
			 왜 board_list.jsp로 바로 리다이렉트를 하면 안될까???
			 board_list.jsp에는 데이터베이스로부터 전체 글 목록을 가져오는
			 로직이 없으니까요. (jsp는 단순히 보여지는 역할만 할 뿐이다.)
			 컨트롤러로 글 목록 요청이 다시 들어올 수 있게끔
			 sendRedirect()를 사용해서 자동 목록 재요청이 들어오게 하는 겁니다.
			 */
			
			response.sendRedirect("/MyWeb/list_board");
			break;
			
		case "list":
			System.out.println("글 목록 요청이 들어옴!");
			sv = new GetListService();
			sv.execute(request, response);
			//사용자에게 정보를 뿌리고나면, 응답 후에는 자동으로 소멸됐으면 좋겠어요 -> request 객체(내가 지워줄필요x)
			
			//sendRedirect를 하면 안되는 이유
			//request객체에 list를 담아서 전달하려 하는데, sendRedirect를 사용하면
			//응답이 나가면서 request 객체가 소멸해 버립니다.
			/* 왜 board_list.jsp로 바로 리다이렉트를 하면 안될까???
					 board_list.jsp에는 데이터베이스로부터 전체 글 목록을 가져오는
					 로직이 없으니까요. (jsp는 단순히 보여지는 역할만 할 뿐이다.)
					 컨트롤러로 글 목록 요청이 다시 들어올 수 있게끔
					 sendRedirect()를 사용해서 자동 목록 재요청이 들어오게 하는 겁니다.*/
//			response.sendRedirect("board/board_list.jsp");
			dp = request.getRequestDispatcher("board/board_list.jsp");
		
			
			//request객체를 다음 화면까지 운반하기 위한 forward 기능을 지원하는 객체
			//-> RequestDispatcher
			/*RequestDispatcher*/
			dp.forward(request, response);
			break;
			
		case "content":
			System.out.println("글 상세보기 요청이 들어옴!");
			sv = new ContentService();
			sv.execute(request, response);
			dp = request.getRequestDispatcher("board/board_content.jsp");
			dp.forward(request, response);
			break;
			
		case "modify":
			System.out.println("글 수정 페이지로 이동 요청!");
			sv = new ModifyService();
			sv.execute(request, response);
			dp = request.getRequestDispatcher("board/board_modify.jsp");
			dp.forward(request, response);
			break;
				
		case "update":
			System.out.println("글 수정 요청이 들어옴!");
			sv = new UpdateService();
			sv.execute(request, response);
			
			response.sendRedirect("/MyWeb/content.board?bId=" + request.getParameter("bId"));
			break;
			
		}
	}

}

