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
		//t_product 테이블 전체 조회 메소드
		temp = dao.allViewProduct();
		//"보낼 이름" , 보낼 데이터
		request.setAttribute("products", temp); 
		//사용자 페이지 이동
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request, response);
			
	}
}
