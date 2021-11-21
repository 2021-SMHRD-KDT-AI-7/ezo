package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.chartDTO;
import Model.webDAO;
import Model.webDTO;

@WebServlet("/webServiceCon")
public class viewWebServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ArrayList<webDTO> temp = new ArrayList<webDTO>();
		webDAO dao = new webDAO();
		//web출처 테이블 전체 조회 메소드
		temp = dao.allViewWebs();
		
		request.setAttribute("allViewWebs", temp); 
		
		RequestDispatcher rd = request.getRequestDispatcher("#");
		rd.forward(request, response);
		
	
	
	}

}
