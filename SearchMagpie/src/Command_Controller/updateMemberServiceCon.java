package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.memberDAO;
import Model.memberDTO;

public class updateMemberServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String path = "";
		memberDAO dao = new memberDAO();
		
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		String m_nickname = request.getParameter("m_nickname");
		String m_email = request.getParameter("m_email");
		String m_phone = request.getParameter("m_phone");
		
		int cnt = dao.updateMember(new memberDTO(m_pw,m_name,m_nickname,m_email,m_phone));
		
		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
