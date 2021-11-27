package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.i_reviewDAO;
import Model.i_reviewDTO;

public class deleteI_reviewServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String path = "";
		i_reviewDAO dao = new i_reviewDAO();

		int i_v_key = Integer.parseInt(request.getParameter("i_v_key"));
		
		int cnt = dao.deleteI_review(new i_reviewDTO(i_v_key));

		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
