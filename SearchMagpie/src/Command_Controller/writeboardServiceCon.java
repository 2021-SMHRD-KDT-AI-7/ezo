package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.writeboardDAO;
import Model.writeboardDTO;

public class writeboardServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		writeboardDAO dao = new writeboardDAO();
		String path = "";
		
		String w_title = request.getParameter("");
		String w_content = request.getParameter("");
		int m_key = Integer.parseInt(request.getParameter(""));
		int w_cnt = Integer.parseInt(request.getParameter(""));
		String w_file1 = request.getParameter("");
		String w_file2 = request.getParameter("");
		
		int cnt = dao.write(new writeboardDTO(w_title,w_content,m_key,w_cnt,w_file1,w_file2));
		
		if(cnt ==1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}
}
