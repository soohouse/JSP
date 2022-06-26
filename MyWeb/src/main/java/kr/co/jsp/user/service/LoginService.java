package kr.co.jsp.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class LoginService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
	    	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		response.setContentType("text/html; charset=UTF-8");
		String htmlCode;

		int result = dao.usercheck(id, pw);
		
		try {
			PrintWriter out = response.getWriter();
			if (result == -1) {
				htmlCode = "script>\n"
						+ "    			alert(\"비밀번호가 틀렸습니다.\");\r\n"
						+ "    			history.back();\r\n"
						+ "			</script>";
					out.print(htmlCode);
					out.flush();
			} else if (result == 0 ) {
				htmlCode = "<script>\n"
						+ "    			alert(\"비밀번호가 틀렸습니다.\");\r\n"
						+ "    			history.back();\n"
						+ "			</script>";
				out.print(htmlCode);
				out.flush();
			} else { //로그인 성공
				UserVO vo = dao.getUserInfo(id);
				request.getSession().setAttribute("user", vo);
				response.sendRedirect("user_mypage.jsp");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

 		  
		
	}

	

}
