package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.writerboardDAO;
import Model.writerboardDTO;
@WebServlet("/writerboardServiceCon")
public class writerboardServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String path = "";
		writerboardDAO dao = new writerboardDAO();
		
		String w_title = request.getParameter("");
		String w_content = request.getParameter("");
		int w_key = Integer.parseInt(request.getParameter(""));
		int w_cnt = Integer.parseInt(request.getParameter(""));
		String w_file1 = request.getParameter("");
		String w_file2 = request.getParameter("");
		
		int cnt = dao.write(new writerboardDTO(w_title,w_content,w_key,w_cnt,w_file1,w_file2));
		
		if(cnt ==1) {
			path = "";
		}else {
			path = "";
		}
		
		response.sendRedirect(path);
	}

}
