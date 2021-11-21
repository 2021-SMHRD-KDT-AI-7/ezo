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
import Model.reservedDTO;

@WebServlet("/viewReservesServiceCon")
public class viewReservesServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ArrayList<reservedDTO> temp = new ArrayList<>();
		reservedDAO dao = new reservedDAO();
		
		temp = dao.allViewReservations();
		
		request.setAttribute("reservations", temp); 
		//사용자 페이지 이동
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request, response);
	}

}
