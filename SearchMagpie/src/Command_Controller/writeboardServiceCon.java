package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Interface.Command;
import Model.writeboardDAO;
import Model.writeboardDTO;

public class writeboardServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		writeboardDAO dao = new writeboardDAO();
		try {
			request.setCharacterEncoding("utf-8");
			String w_title = request.getParameter("w_title");
			String w_content = request.getParameter("c_conent");
			
			System.out.println(w_content);

			String w_writer = "user";
			int w_cnt = 0;
			String w_file1 = "test";
			String w_file2 = "test";

			int cnt = dao.write(new writeboardDTO(w_title, w_content, w_writer, w_cnt, w_file1, w_file2));

		} catch (Exception e) {
			System.err.println(e);
		}
	
		return "board_MainFrame.jsp";
	}
}
