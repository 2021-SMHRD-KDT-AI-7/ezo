package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.writerboardDAO;
import Model.writerboardDTO;

@WebServlet("/updateWriterboardServiceCon")
public class updateWriterboardServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		writerboardDAO dao = new writerboardDAO();
		ArrayList<writerboardDTO> temp = new ArrayList<>();
		String path = "";
		
		int w_key = Integer.parseInt(request.getParameter(""));
		String w_title = request.getParameter("");
		String w_content = request.getParameter("");
		String w_file1 = request.getParameter("");
		String w_file2 = request.getParameter("");
		
		
		temp = dao.updateWriterboard(new writerboardDTO(w_key,w_title,w_content,w_file1,w_file2));
		
		request.setAttribute("updateWriter", temp); 
		
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request, response);
	}

}
