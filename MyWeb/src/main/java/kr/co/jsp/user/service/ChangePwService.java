package kr.co.jsp.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class ChangePwService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String oldPw = request.getParameter("old_pw");
	    String newPw = request.getParameter("new_pw");
	    
	    UserVO vo = (UserVO) request.getSession().getAttribute("user");
	    String id = vo.getId();
	    
	    //String id = ((UserVO) session.getAttribute("user")).getId();
	    
	   UserDAO dao = UserDAO.getInstance();
	   
	   response.setContentType("text/html; charset=UTF-8");
	   
	   String htmlCode;
	   
	   //이미 로그인중이라 -1은 절대 안와
	   try {
		PrintWriter out = response.getWriter();
		 if(dao.usercheck(id, oldPw) == 1 ) { 
		    	dao.changePassword(id, newPw);
		    	htmlCode = "<script>\n"
		    			+ "	    		alert(\"비밀번호가 정상적으로 변경되었습니다.\");\n"
		    			+ "	    		location.href=\"user_mypage.jsp\";\n"
		    			+ "	    	</script>";
		    	out.print(htmlCode);
		    	out.flush();
		 } else {
			 htmlCode = "<script>\n"
			 		+ "	    		alert(\"현재 비밀번호가 다릅니다.\");\n"
			 		+ "	    		history.back();\n"
			 		+ "	    	</script>";
			 out.print(htmlCode);
			 out.flush();
		 }
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
	   
	   
	}

	

}
