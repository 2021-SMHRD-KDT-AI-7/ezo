package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.alarmDAO;
import Model.alarmDTO;

public class alarmServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		alarmDAO dao = new alarmDAO();
		String path = "";
		int a_key = Integer.parseInt(request.getParameter("a_key"));
		int r_key = Integer.parseInt(request.getParameter("r_key"));
		String a_content = request.getParameter("a_content");

		int cnt = dao.insertAlarm(new alarmDTO(a_key, r_key, a_content));
		
		if(cnt==1) {
			path = "성공 rul";
		}else {
			path = "실패 url";
		}
		return path;
	}

}
