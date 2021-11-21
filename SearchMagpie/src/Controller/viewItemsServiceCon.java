package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.itemDTO;
import Model.itemDAO;

@WebServlet("/viewItemsServiceCon")
public class viewItemsServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ArrayList<itemDTO> temp = new ArrayList<itemDTO>();
		itemDAO dao = new itemDAO();
		
		temp = dao.allViewItems();
		
		request.setAttribute("allViewItems", temp); 
		
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request, response);
	
	}

}
