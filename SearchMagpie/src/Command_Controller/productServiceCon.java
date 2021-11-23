package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.productDAO;
import Model.productDTO;

public class productServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		productDAO dao = new productDAO();
		String path = "";
		String p_name = request.getParameter("p_name");
		int p_price = Integer.parseInt(request.getParameter("p_price"));
		int web_key = Integer.parseInt(request.getParameter("web_key"));
		String p_pic1 = request.getParameter("p_pic1");
		String p_pic2 = request.getParameter("p_pic2");
		String p_pic3 = request.getParameter("p_pic3");
		String p_pic4 = request.getParameter("p_pic4");
		
		
		int cnt = dao.insertProduct(new productDTO(p_name, p_price, web_key,p_pic1,p_pic2,p_pic3,p_pic4));
		
		if(cnt == 1) {
			path = "성공 url";
		}else {
			path = "실패 url";
		}
		return path;
		
		
		
	}

}
