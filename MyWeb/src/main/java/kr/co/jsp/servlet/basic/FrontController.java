package kr.co.jsp.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출!");
		System.out.println("요청 URI: " + request.getRequestURI());
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); // /MyWeb
		
		uri = uri.substring(conPath.length() + 1, uri.lastIndexOf("."));
		System.out.println("정제된 uri: " + uri);
		
		if(uri.equals("write")) {
			System.out.println("글 작성 요청이 들어옴!");
			//~~~~~~
		} else if(uri.equals("list")) {
			System.out.println("글 목록 요청이 들어옴!");
			//~~~~~
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








