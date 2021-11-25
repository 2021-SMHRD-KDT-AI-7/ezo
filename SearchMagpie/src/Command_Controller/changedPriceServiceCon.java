package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.changedPriceDAO;
import Model.changedPriceDTO;

public class changedPriceServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		changedPriceDAO dao = new changedPriceDAO();
		String path = "";
		int cp_key = Integer.parseInt(request.getParameter("cp_key"));
		int p_key = Integer.parseInt(request.getParameter("p_key"));
		int p_price = Integer.parseInt(request.getParameter("p_peice"));
		String reg_date = request.getParameter("reg_date");
			
		
		
		int cnt = dao.insertChangedPrice(new changedPriceDTO(cp_key,p_key,p_price,reg_date));
		
		if(cnt==1) {
			path = "�Է� ���� url";
		}else {
			path = "�Է� ���� rul";
		}
		return path;
	}

}
