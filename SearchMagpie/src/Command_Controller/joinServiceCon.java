package Command_Controller;

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
		
		String id = request.getParameter("m_id");
		String pw = request.getParameter("m_pw");
		String name = request.getParameter("m_name");
		String nickname = request.getParameter("m_nickname");
		String email = request.getParameter("m_email");
		String phone = request.getParameter("m_phone");
		
		System.out.println(
				"아이디 : " + id + 
				"비번 : " + pw + 
				"이름 : " + name + 
				"닉네임 : " + nickname + 
				"아이디 : " + email + 
				"아이디 : " + phone);
		
		cnt = dao.join(new memberDTO(id,pw,name,nickname,email,phone));
		
		if(cnt == 1) {
			path = "Main.jsp";
		}else {
			path = "joinFrame.jsp";
		}
		System.out.println("경로" + path);
		return path;
	}

}
