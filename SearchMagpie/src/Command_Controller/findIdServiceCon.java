package Command_Controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		String m_id = "";
	    try {
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			memberDAO dao = new memberDAO();

			String m_name = request.getParameter("m_name");
			String m_email = request.getParameter("m_email");
			
			m_id = dao.findId(m_name, m_email);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		return "find_idFrame.jsp?m_id="+m_id;
	}
}
