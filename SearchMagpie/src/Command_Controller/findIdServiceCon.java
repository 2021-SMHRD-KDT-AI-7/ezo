package Command_Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.memberDAO;
import Model.memberDTO;

public class findIdServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[findIdServiceCon]");
		memberDAO dao = new memberDAO();

		String m_name = request.getParameter("m_name");
		String m_email = request.getParameter("m_email");
		System.out.println("이름 : " + m_name + "이메일 : " + m_email);
		String m_id = dao.findId(new memberDTO(m_name, m_email));

		return m_id;
	}
}
