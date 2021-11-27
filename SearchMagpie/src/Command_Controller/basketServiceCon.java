package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.basketDAO;
import Model.basketDTO;

public class basketServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String path = "";
		basketDAO dao = new basketDAO();

		int m_key = Integer.parseInt(request.getParameter("m_key"));
		int p_key = Integer.parseInt(request.getParameter("p_key"));
		int item_key = Integer.parseInt(request.getParameter("item_key"));
		String reg_date = request.getParameter("reg_date");
		
		int cnt = dao.insertBasket(new basketDTO(m_key, p_key, item_key, reg_date));
			
		if(cnt == 1) {
			path = "";
		}else {
			path = "";
		}
		return path;
	}

}
