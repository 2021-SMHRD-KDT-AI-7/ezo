package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.webDAO;
import Model.webDTO;
@WebServlet("/webServiceCon")
public class webServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		webDAO dao = new webDAO();
		String path = "";
		
		String web_name = request.getParameter(null);
		String web_url = request.getParameter(null);
		
		int cnt = dao.insertWeb(null, null);
		
		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		response.sendRedirect(path);
	
	}

}
