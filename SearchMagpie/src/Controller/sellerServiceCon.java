package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.sellerDAO;
import Model.sellerDTO;

@WebServlet("/sellerServiceCon")
public class sellerServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		sellerDAO dao = new sellerDAO();
		String path = "";
		String seller_name = request.getParameter("seller_name");
		//�ؿ����� �Ǹ��� ��� �޼ҵ�
		int cnt = dao.insertSeller(new sellerDTO(seller_name));
		if(cnt==1) {
			path = "��� ���� url";
		}else {
			path = "��� ���� rul";
		}
		response.sendRedirect(path);
	}
}
