package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.sellerDAO;
import Model.sellerDTO;
@WebServlet("/viewSellerServiceCon")
public class viewSellerServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ArrayList<sellerDTO> temp = new ArrayList<>();
		sellerDAO dao = new sellerDAO();
		
		temp = dao.allViewSellers();
		//"���� �̸�" , ���� ������
		request.setAttribute("sellers", temp); 
		//����� ������ �̵�
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request, response);
	}

}
