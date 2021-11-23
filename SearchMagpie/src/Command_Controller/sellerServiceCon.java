package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.sellerDAO;
import Model.sellerDTO;

public class sellerServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
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
		return path;
	}

}
