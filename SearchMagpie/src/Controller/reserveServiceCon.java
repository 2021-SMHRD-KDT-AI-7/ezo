package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.reservedDAO;

@WebServlet("/reserveServiceCon")
public class reserveServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		reservedDAO dao = new reservedDAO();
		String path = "";
		//���� ����Ʈ���� ��������� �Ķ���� �� �ֱ�
		//�����ϱ� �޼ҵ�
		int cnt = dao.reserve(null);
	
		if(cnt ==1) {
			path = "���� ���� url";
		}else {
			path = "���� ���� url";
		}

		response.sendRedirect(path);
	}

}
