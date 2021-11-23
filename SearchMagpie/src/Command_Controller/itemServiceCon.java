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
		itemDAO dao = new itemDAO();
		String path = "";
		int seller_key = Integer.parseInt(request.getParameter("seller_key"));
		int web_key = Integer.parseInt(request.getParameter("web_key"));
		String item_title = request.getParameter("item_title");
		String item_content = request.getParameter("item_content");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		String item_file1 = request.getParameter("item_file1");
		String item_file2 = request.getParameter("item_file2");
		String item_file3 = request.getParameter("item_file3");
		String item_file4 = request.getParameter("item_file4");

		int cnt = dao.insertItem(new itemDTO(seller_key, web_key, item_title, item_content, item_price,
				item_file1, item_file2, item_file3, item_file4));

		if (cnt == 1) {
			path = "성공 rul";
		} else {
			path = "실패 url";
		}
		return path;
	}

}
