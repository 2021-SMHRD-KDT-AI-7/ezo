package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.memberDAO;
import Model.memberDTO;

@WebServlet("/loginServiceCon")
public class loginServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[로그인]");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		memberDAO dao = new memberDAO();
		String path = "";

		if (dao.login(new memberDTO(id, pw))) {
			System.out.println("성공");
			path = "Main.jsp";
		} else {
			System.out.println("실패");
			path = "Main.jsp";
		}
		// 결과 값은 경로를 보낸다.
		request.setAttribute("path", path);

		RequestDispatcher rd = request.getRequestDispatcher("Main.jsp");
		rd.forward(request, response);

	}
}
