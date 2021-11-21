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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		memberDAO dao = new memberDAO();
		String path = "";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//�α��� ���� ��
		if(dao.login(new memberDTO(id,pw))) {
			path = "�α��� ���� �� url";
		}else {
			path = "�α��� ���� �� url";
		}
		//��� ���� ��θ� ������.
		request.setAttribute("path",path);
		
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request,response);
		
	}

}
