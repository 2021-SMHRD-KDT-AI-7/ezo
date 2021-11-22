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
@WebServlet("/viewProductServiceCon")
public class viewProductServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ArrayList<productDTO> temp = new ArrayList<>();
		productDAO dao = new productDAO();
		//t_product ���̺� ��ü ��ȸ �޼ҵ�
		temp = dao.allViewProduct();
		//"���� �̸�" , ���� ������
		request.setAttribute("products", temp); 
		//����� ������ �̵�
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request, response);
			
	}
}