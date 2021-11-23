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
		int p_key = Integer.parseInt(request.getParameter("p_key"));
		int item_key = Integer.parseInt(request.getParameter("item_key"));
		int p_price = Integer.parseInt(request.getParameter("p_peice"));
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		int ch_difference = Integer.parseInt(request.getParameter("ch_difference"));		
		
		
		//���ݺ��� �Է� �޼ҵ�
		int cnt = dao.insertChangedPrice(new changedPriceDTO(p_key,item_key,p_price,item_price,ch_difference));
		
		if(cnt==1) {
			path = "�Է� ���� url";
		}else {
			path = "�Է� ���� rul";
		}
		return path;
	}

}
