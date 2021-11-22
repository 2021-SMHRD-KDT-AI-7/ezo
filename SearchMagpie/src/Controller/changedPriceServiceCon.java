package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.changedPriceDAO;
import Model.changedPriceDTO;

@WebServlet("/changedPriceServiceCon")
public class changedPriceServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[가격 변동 알림]");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		changedPriceDAO dao = new changedPriceDAO();
		String path = "";
		int p_key = Integer.parseInt(request.getParameter("p_key"));
		int item_key = Integer.parseInt(request.getParameter("item_key"));
		int p_price = Integer.parseInt(request.getParameter("p_peice"));
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		int ch_difference = Integer.parseInt(request.getParameter("ch_difference"));

		// 가격변동 입력 메소드
		int cnt = dao.insertChangedPrice(new changedPriceDTO(p_key, item_key, p_price, item_price, ch_difference));

		if (cnt == 1) {
			path = "changedPrice.html";
		} else {
			path = "changedPrice.html";
		}
		response.sendRedirect(path);
	}

}
