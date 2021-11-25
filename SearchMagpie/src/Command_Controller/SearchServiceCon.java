package Command_Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.SearchProductDAO;
import Model.SearchProductDTO;

@SuppressWarnings("serial")
@WebServlet("/SearchServiceCon")
public class SearchServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[SearchServiceCon]");
		SearchProductDAO dao = new SearchProductDAO();
		
		HttpSession session = request.getSession();
		ArrayList<SearchProductDTO> list = new ArrayList<SearchProductDTO>();

		request.setCharacterEncoding("UTF-8");
		String findKeyword = request.getParameter("userKeyword");

		list = dao.Search_find(findKeyword);
		if (list.size() > 0) {
			session.setAttribute("findKeywordList", list);
			response.sendRedirect("productResult.jsp");
		} else {
			System.out.println("<" + findKeyword + ">결과값이 존재하지 않습니다.");
		}
	}
}
