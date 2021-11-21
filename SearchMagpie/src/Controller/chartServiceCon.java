package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.chartDAO;
import Model.chartDTO;

@WebServlet("/chartServiceCon")
public class chartServiceCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ArrayList<chartDTO> temp = new ArrayList<chartDTO>();
		chartDAO dao = new chartDAO();
		//t_product 조회수 상위 10개 키, 이름, 조회수 리턴 메소드
		temp = dao.getViewCountTopTen();
		
		request.setAttribute("chartTopTen", temp); 
		
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request, response);
	}
}
