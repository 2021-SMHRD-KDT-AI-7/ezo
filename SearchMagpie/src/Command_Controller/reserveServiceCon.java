package Command_Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.reservedDAO;

public class reserveServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		reservedDAO dao = new reservedDAO();
		String path = "";
		//���� ����Ʈ���� ��������� �Ķ���� �� �ֱ�
		//�����ϱ� �޼ҵ�
		int cnt = dao.reserve(null);
	
		if(cnt ==1) {
			path = "���� ���� url";
		}else {
			path = "���� ���� url";
		}

		return path;
	}

}
