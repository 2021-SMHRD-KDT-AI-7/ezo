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
		//예약 프론트엔드 만들어지면 파라미터 값 넣기
		//예약하기 메소드
		int cnt = dao.reserve(null);
	
		if(cnt ==1) {
			path = "예약 성공 url";
		}else {
			path = "예약 실패 url";
		}

		return path;
	}

}
