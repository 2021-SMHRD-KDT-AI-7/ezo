package Command_Controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.writeboardDAO;

public class deleteWriteboardServiceCon implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			writeboardDAO dao = new writeboardDAO();
			// w_key 를 입력 받으면 삭제 가능
			int w_key = Integer.parseInt(request.getParameter("w_key"));

			System.out.print("키 값 : " + w_key);

			dao.deleteWriteboard(w_key);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "board_MainFrame.jsp";
	}
}
