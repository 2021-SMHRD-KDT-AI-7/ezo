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
		System.out.println("[�α���]");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		memberDAO dao = new memberDAO();
		String path = "";

		if (dao.login(new memberDTO(id, pw))) {
			System.out.println("����");
			path = "Main.jsp";
		} else {
			System.out.println("����");
			path = "Main.jsp";
		}
		// ��� ���� ��θ� ������.
		request.setAttribute("path", path);

		RequestDispatcher rd = request.getRequestDispatcher("Main.jsp");
		rd.forward(request, response);

	}
}
