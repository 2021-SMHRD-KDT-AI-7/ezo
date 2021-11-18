package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chartServiceCon")
public class chartServiceCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DB t_product로부터 제품 고유의 seq 번호를 받아온다.
		//2. chartDAO의 getViewCount(seq번호 입력)
		//3. DTO로부터 해당 제품 카테고리,이름,가격,사진을 가지고 온다.
		//4. 가지고 온 정보를 뷰로 보낸다
		
		//2021.11.18 10:45 현재 시각 제품들이 DB에 아직 저장이 
		//안 된 상태라 지금 진행하기엔 다소 어려움
		
	}

}
