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

		String w_title = request.getParameter("w_title");
		String w_content = request.getParameter("c_conent");
		String w_writer = request.getParameter("w_writer");
		int w_cnt = Integer.parseInt(request.getParameter("w_cnt"));
		String w_file1 = request.getParameter("w_file1");
		String w_file2 = request.getParameter("w_file2");

		int cnt = dao.write(new writeboardDTO(w_title, w_content, w_writer, w_cnt, w_file1, w_file2));

		String path = "board_MainFrame.jsp";
		return path;
	}
}
