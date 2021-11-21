package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.commentDAO;
import Model.commentDTO;

@WebServlet("/commentServiceCon")
public class commentServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String path = "";
		commentDAO dao = new commentDAO();

		int w_key = Integer.parseInt(request.getParameter(""));
		int m_key = Integer.parseInt(request.getParameter(""));
		String c_comment = request.getParameter("");

		int cnt = dao.comment(new commentDTO(w_key, m_key, c_comment));

		if (cnt == 1) {
			path = "";
		} else {
			path = "";

			response.sendRedirect(path);
		}
	}

}
