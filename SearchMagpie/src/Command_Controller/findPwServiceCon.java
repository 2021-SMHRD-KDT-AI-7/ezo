package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.memberDAO;
import Model.memberDTO;

public class findPwServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		memberDAO dao = new memberDAO();
		
		String m_id = request.getParameter("m_id");
		String m_email = request.getParameter("m_email");
		
		String m_pw = dao.findPw(m_id, m_email);
		
		return "find_pwFrame.jsp?m_pw="+m_pw;
	}


}
