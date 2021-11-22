package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.memberDAO;
import Model.memberDTO;
import Model.productDAO;
import Model.productDTO;

@WebServlet("/joinServiceCon")
public class joinServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[회원가입]");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		memberDAO dao = new memberDAO();
		int cnt = 0;
		String path = "";
		String id = request.getParameter("id");
		//String id_check = request.getParameter("id_check");
		String pw = request.getParameter("pw");
		//String pw_check = request.getParameter("pw_check");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		//String nickname_check = request.getParameter("nickname_check");
		String email = request.getParameter("email");
		//String email_check = request.getParameter("email_check");
		String phone = request.getParameter("phone");
		
		//회원정보 
		//memberDTO 회원가입전용 생성자 메소드 만들기 
		//cnt = dao.joinMember(new memberDTO(id,pw,name,nickname,email,phone));
		if(cnt == 1) {
			System.out.println("성공");
			path = "joinSuccess.html";
		}else {
			System.out.println("실패");
			path = "join.html";
		}
		response.sendRedirect(path);
	}

}
