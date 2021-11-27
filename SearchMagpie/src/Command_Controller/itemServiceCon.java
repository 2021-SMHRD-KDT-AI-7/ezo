package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.alarmDTO;
import Model.itemDAO;
import Model.itemDTO;

public class itemServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		itemDAO dao = new itemDAO();
		String path = "";
		int item_key = Integer.parseInt(request.getParameter("item_key"));
		String item_title = request.getParameter("item_title");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		int item_cnt = Integer.parseInt(request.getParameter("item_cnt"));
		String item_url = request.getParameter("item_url");
		String item_category = request.getParameter("item_category");
		String reg_date = request.getParameter("reg_date");
		String item_source = request.getParameter("item_source");
		String item_file1 = request.getParameter("item_file1");
		String item_file2 = request.getParameter("item_file2");
		String item_file3 = request.getParameter("item_file3");
		String item_file4 = request.getParameter("item_file4");

		int cnt = dao.insertItem(new itemDTO(item_key,item_title,item_price,item_cnt,item_url,item_category,reg_date,item_source,item_file1,item_file2,item_file3,item_file4));

		if (cnt == 1) {
			path = "���� rul";
		} else {
			path = "���� url";
		}
		return path;
	}

}
