package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.webDAO;

public class webServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		webDAO dao = new webDAO();
		String path = "";
		
		String web_name = request.getParameter(null);
		String web_url = request.getParameter(null);
		
		int cnt = dao.insertWeb(null, null);
		
		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
