package Command_Controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Interface.Command;
import Model.basketDAO;
import Model.basketDTO;

public class InsertWishServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			int seq	= Integer.parseInt(request.getParameter("seq"));
			int m_key	= Integer.parseInt(request.getParameter("m_key"));
			basketDTO temp = null;
			basketDAO dao = new basketDAO();
			
			System.out.print("seq : "+seq);
			System.out.print("m_key : "+m_key);
			
			int cnt = dao.addBasket(m_key,seq);
			
			System.out.print("입력 여부 cnt값 : "+cnt);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
	return "productResult.jsp";	
	}

}
