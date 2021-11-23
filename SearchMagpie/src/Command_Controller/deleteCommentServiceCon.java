package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.commentDAO;

public class deleteCommentServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		commentDAO dao = new commentDAO();
		String path = "";
		
		int c_key = Integer.parseInt(request.getParameter(""));
		
		int cnt = dao.deleteComment(c_key);
		
		if(cnt ==1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
