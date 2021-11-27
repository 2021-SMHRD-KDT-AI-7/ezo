package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Interface.Command;
import Model.memberDAO;
import Model.memberDTO;

public class loginServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");

		memberDAO dao = new memberDAO();

		memberDTO info = dao.login(m_id, m_pw);

		if (info != null) {
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("info", info);
		} else {
			System.out.println("로그인 실패");
		}
		return "Main.jsp";
	}

}
