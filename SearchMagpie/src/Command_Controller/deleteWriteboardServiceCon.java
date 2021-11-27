package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.writeboardDAO;

public class deleteWriteboardServiceCon implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		writeboardDAO dao = new writeboardDAO();
		String path = "";

		int w_key = Integer.parseInt(request.getParameter(""));

		int cnt = dao.deleteWriteboard(w_key);

		if (cnt == 1) {
			path = "";
		} else {
			path = "";
		}
		return path;
	}

}
