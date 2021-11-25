package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.memberDAO;
import Model.memberDTO;

public class findPwServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		memberDAO dao = new memberDAO();
		
		String m_id = request.getParameter("m_id");
		String m_email = request.getParameter("m_email");
		
		String m_pw = dao.findPw(new memberDTO(m_id, m_email));
		
		return m_pw;
	}


}
