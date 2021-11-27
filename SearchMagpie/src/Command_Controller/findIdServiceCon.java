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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("[findIdServiceCon]");
		memberDAO dao = new memberDAO();

		String m_name = request.getParameter("m_name");
		String m_email = request.getParameter("m_email");
		System.out.println("�̸� : " + m_name + "�̸��� : " + m_email);
		String m_id = dao.findId(new memberDTO(m_name, m_email));
		System.out.println("id:" + m_id);
		return "Main.jsp"+m_id;
	}
}
