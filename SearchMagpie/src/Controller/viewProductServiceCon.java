package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.productDAO;
import Model.productDTO;

import java.util.*;
@WebServlet("/insertProductServiceCon")
public class insertProductServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		ArrayList<productDTO> temp = new ArrayList<>();
		productDAO dao = new productDAO();
		temp = dao.allViewProduct();
		//DB�� �ִ� ��ǰ �ڷḦ ������ ����
		request.setAttribute("products", temp);
		//����� ������ �̵�
		RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
		//�ѱ����.
		rd.forward(request, response);

		
			
	}
}
