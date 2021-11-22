 v package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.commentDAO;

@WebServlet("/deleteCommentServiceCon")
public class deleteCommentServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		commentDAO dao = new commentDAO();
		String path = "";
		
		int c_key = Integer.parseInt(request.getParameter(""));
		
		int cnt = dao.deleteComment(c_key);
		
		if(cnt ==1) {
			path = "";
		}else {
			path = "";
		}
		
		response.sendRedirect(path);
	}

}
