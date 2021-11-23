package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.p_reviewDAO;
import Model.p_reviewDTO;

public class p_reviewServiceCon implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		p_reviewDAO dao = new p_reviewDAO();

		int m_key = Integer.parseInt(request.getParameter("m_key"));
		int p_key = Integer.parseInt(request.getParameter("p_key"));
		String p_title = request.getParameter("p_title");
		String v_content = request.getParameter("v_content");
		int v_score = Integer.parseInt(request.getParameter("v_score"));
		String v_file1 = request.getParameter("v_fiel1");
		String v_file2 = request.getParameter("v_fiel2");
		
		int cnt = dao.insertP_review(new p_reviewDTO(m_key,p_key,p_title,v_content,v_score,v_file1,v_file2));

		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
