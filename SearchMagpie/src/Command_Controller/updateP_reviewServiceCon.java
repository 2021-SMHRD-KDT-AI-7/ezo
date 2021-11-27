package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.p_reviewDAO;
import Model.p_reviewDTO;

public class updateP_reviewServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String path = "";
		p_reviewDAO dao = new p_reviewDAO();

		String p_title = request.getParameter("p_title");
		String v_content = request.getParameter("v_content");
		int p_v_key = Integer.parseInt(request.getParameter("p_v_key"));
		
		int cnt = dao.updateP_review(new p_reviewDTO(p_title,v_content,p_v_key));

		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
