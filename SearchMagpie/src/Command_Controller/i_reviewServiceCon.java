package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.i_reviewDAO;
import Model.i_reviewDTO;

public class i_reviewServiceCon implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		i_reviewDAO dao = new i_reviewDAO();

		int m_key = Integer.parseInt(request.getParameter("m_key"));
		int item_key = Integer.parseInt(request.getParameter("item_key"));
		String item_title = request.getParameter("item_title");
		String v_content = request.getParameter("v_content");
		int v_score = Integer.parseInt(request.getParameter("v_score"));
		String v_file1 = request.getParameter("v_fiel1");
		String v_file2 = request.getParameter("v_fiel2");
		
		int cnt = dao.insertI_review(new i_reviewDTO(m_key,item_key,item_title,v_content,v_score,v_file1,v_file2));

		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
