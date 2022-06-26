package kr.co.jsp.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class DeleteService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		UserVO vo = (UserVO) request.getSession().getAttribute("user");
    	String id = vo.getId();
    
    	String pw = request.getParameter("check_pw");
    	
    	UserDAO dao = UserDAO.getInstance();
    	
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String htmlCode;
    	
    	try {
			PrintWriter out = response.getWriter();
			if(dao.usercheck(id, pw) == 0) {
				htmlCode = "<script>\n"
						+ "    		alert(\"비밀번호가 틀렸습니다.\");\n"
						+ "    		location.href=\"user_mypage.jsp\";\n"
						+ "    	</script>";
				out.print(htmlCode);
				out.flush();
			} else {
				dao.deleteUser(id);
		    	request.getSession().invalidate();
		    	htmlCode = "<script>\n"
		    			+ "    		alert(\"회원 탈퇴가 정상적으로 처리되었습니다.\");\n"
		    			+ "    		location.href=\"/Myweb\";\n"
		    			+ "    	</script>";
		    	out.print(htmlCode);
		    	out.flush();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
