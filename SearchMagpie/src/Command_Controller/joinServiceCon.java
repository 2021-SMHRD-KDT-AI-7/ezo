package Command_Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.Command;
import Model.memberDAO;
import Model.memberDTO;

public class joinServiceCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		memberDAO dao = new memberDAO();
		int cnt = 0;
		String path = "";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		
		cnt = dao.join(new memberDTO(id,pw,name,nickname,email,phone));
		
		if(cnt == 1) {
			path = "회원가입 성공 시 url";
		}else {
			path = "회원가입 실패 시 url";
		}

		return path;
	}

}
