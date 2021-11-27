package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.basketDAO;
import Model.basketDTO;

public class deleteBasketServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String path = "";
		basketDAO dao = new basketDAO();

		int m_key = Integer.parseInt(request.getParameter("m_key"));
		
		int cnt = dao.insertBasket(new basketDTO(m_key));
			
		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
