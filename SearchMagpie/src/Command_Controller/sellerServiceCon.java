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
		//해외직구 판매자 등록 메소드
		int cnt = dao.insertSeller(new sellerDTO(seller_name));
		if(cnt==1) {
			path = "등록 성공 url";
		}else {
			path = "등록 실패 rul";
		}
		return path;
	}

}
