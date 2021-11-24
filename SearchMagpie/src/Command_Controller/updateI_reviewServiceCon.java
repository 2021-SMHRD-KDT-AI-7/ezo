package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.i_reviewDAO;
import Model.i_reviewDTO;

public class updateI_reviewServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		i_reviewDAO dao = new i_reviewDAO();

		String item_title = request.getParameter("item_title");
		String v_content = request.getParameter("v_content");
		int i_v_key = Integer.parseInt(request.getParameter("i_v_key"));
		
		int cnt = dao.updateI_review(new i_reviewDTO(item_title,v_content,i_v_key));
		
		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
