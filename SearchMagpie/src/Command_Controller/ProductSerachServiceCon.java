package Command_Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Interface.Command;
import Model.productDAO;
import Model.productDTO;

public class ProductSerachServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//정배가 만든 경로로 보내기.
		String path = "";
		HttpSession session=request.getSession();
		
		ArrayList<productDTO> dto_list = new ArrayList<productDTO>();
		int find_product_seq=Integer.parseInt(request.getParameter("seq"));
		productDAO dao = new productDAO();
		
		dto_list=dao.find_product(find_product_seq);
		
		//검색 데이터 가져옴
		if(dto_list.size()>0) {
			path = "productFrame.jsp";
			session.setAttribute("products", dto_list);
		}
		//안가져왔을 때.
		else {
			path = "main.jsp";
		}
		
		return path;
	}

}
