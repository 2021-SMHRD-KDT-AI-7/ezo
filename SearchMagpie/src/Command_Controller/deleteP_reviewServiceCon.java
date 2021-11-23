package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.p_reviewDAO;
import Model.p_reviewDTO;

public class deleteP_reviewServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		p_reviewDAO dao = new p_reviewDAO();

		int p_v_key = Integer.parseInt(request.getParameter("p_v_key"));
		
		int cnt = dao.deleteP_review(new p_reviewDTO(p_v_key));

		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
