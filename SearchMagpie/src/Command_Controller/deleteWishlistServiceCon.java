package Command_Controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.basketDAO;

public class deleteWishlistServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			basketDAO dao = new basketDAO();

			int m_key = Integer.parseInt(request.getParameter("m_key"));
			
			System.out.print("Å° °ª : "+m_key);
			
			dao.deleteWishlist(m_key);
	
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	

		return "wish.jsp";
		
	}

}
