package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.productDAO;
import Model.productDTO;

public class productServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		productDAO dao = new productDAO();
		String path = "";
		String p_title = request.getParameter("p_title");
		int p_price = Integer.parseInt(request.getParameter("p_price"));
		String p_url = request.getParameter("p_url");
		String p_category = request.getParameter("p_category");
		String p_source = request.getParameter("p_source");
		String p_file1 = request.getParameter("p_file1");
		String p_file2 = request.getParameter("p_file2");
		String p_file3 = request.getParameter("p_file3");
		String p_file4 = request.getParameter("p_file4");
		
		
		int cnt = dao.insertProduct(new productDTO(p_title,p_price,p_url,p_category,p_source,p_file1,p_file2,p_file3,p_file4));
		
		if(cnt == 1) {
			path = "���� url";
		}else {
			path = "���� url";
		}
		return path;
		
		
		
	}

}
