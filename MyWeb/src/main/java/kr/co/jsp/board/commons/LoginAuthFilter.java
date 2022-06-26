package kr.co.jsp.board.commons;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//@WebFilter("*.board")
@WebFilter (filterName = "loginAuth",
			urlPatterns = {"/write.boaard","/delete.board","/user/user_mypage.jsp"},
			servletNames = {"basic"}
			)
public class LoginAuthFilter implements Filter {

    
    public LoginAuthFilter() {
      
    }

	
	public void destroy() {
		// 필터 객체가 제거될 때 실행하는 메서드
		// 보통 초기화 시 생성했던 자원들을 종료하는 기능에 사용합니다.
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 - 필터의 핵심 메서드! doFilter()는 클라이언트의 요청이 있을 때마다 실행됩니다.
		 - request객체와 response객체를 넘겨주기 때문에 이를 가지고 요청과 응답을 조작할 수 있습니다.
		 - 그리고 FilterChain을 통해 조작 이후 요청을 원래 목적지인 서블릿으로 전달할 수 있다.
		 */
		System.out.println("doFilter 메서드 발동!");
		
		//우리가 평소에 사용하던 타입은 HttpServletRequest입니다.
		//부모타입의 ServletRequest를 자식타입으로 끌어 내리시면 사용이 가능합니다.
		HttpSession session = ((HttpServletRequest)request).getSession();
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// 필수아님
		// 웹컨테이너(서버)가 시작될 때 필터 객체를 생성하는데,
		// 이 때 객체가 생성되면서 최초 한 번 호출되는 메서드입니다.
		// 필터에서 처리 시 필요한 객체등을 초기화 (JDBC관련 설정)하는 데 사용합니다.
		System.out.println("로그인 권한 필터 객체 생성!");
		
	}

}
