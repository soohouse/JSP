package kr.co.jsp.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class UpdateService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		UserVO vo = new UserVO();
	    vo.setId(request.getParameter("id"));//readonly걸려있던 id
	    vo.setName(request.getParameter("name"));
	    vo.setEmail(request.getParameter("email"));
	    vo.setAddress(request.getParameter("address"));
	    
	    UserDAO dao = UserDAO.getInstance(); //dao주소값 받아오는것
	    dao.updateUser(vo);
	    request.getSession().setAttribute("user", dao.getUserInfo(vo.getId()));
	    
	    response.setContentType("text/html; charset=UTF-8");
	    
	    try { PrintWriter out = response.getWriter();
			String htmlCode = "<script>\\"
					+ "alert(\"회원 정보가 수정되었습니다.\");\n"
					+ "	    	location href=\"user_update.jsp\n"
					+ "</script>";
			out.print(htmlCode);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
	    
	}

}
