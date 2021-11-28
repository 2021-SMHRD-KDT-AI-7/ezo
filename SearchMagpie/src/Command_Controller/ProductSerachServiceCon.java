package Command_Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Interface.Command;
import Model.productDAO;
import Model.productDTO;

public class ProductSerachServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//���谡 ���� ��η� ������.
		String path = "";
		HttpSession session=request.getSession();
		
		ArrayList<productDTO> dto_list = new ArrayList<productDTO>();
		int find_product_seq=Integer.parseInt(request.getParameter("seq"));
		productDAO dao = new productDAO();
		
		dto_list=dao.find_product(find_product_seq);
		
		//�˻� ������ ������
		if(dto_list.size()>0) {
			path = "productFrame.jsp";
			session.setAttribute("products", dto_list);
		}
		//�Ȱ������� ��.
		else {
			path = "main.jsp";
		}
		
		return path;
	}

}
