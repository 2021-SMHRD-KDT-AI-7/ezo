package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.commentDAO;
import Model.commentDTO;
import Model.writerboardDTO;

@WebServlet("/updateCommentServiceCon")
public class updateCommentServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		commentDAO dao = new commentDAO();
		String content = "";
		String path = "";
		
		int c_key = Integer.parseInt(request.getParameter(""));
		String c_content = request.getParameter("");
		
		content = dao.updateComment(new commentDTO(c_key,c_content));
		
		request.setAttribute("content", content); 
		
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request, response);
	}

}
