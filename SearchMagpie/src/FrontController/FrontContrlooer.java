package FrontController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command_Controller.*;
import Interface.Command;
import Model.*;

@WebServlet("*.do")
public class FrontContrlooer extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("FrontController");

		String reqURI = request.getRequestURI();

		String project = request.getContextPath();

		String result = reqURI.substring(project.length() + 1);

		String path = null;

		Command sc = null;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// 게시판 입력
		if (result.equals("writeboardServiceCon")) {
			sc = new writeboardServiceCon();
			// 게시판 전체 조회
		} else if (result.equals("viewWriteboardServiceCon")) {
			ArrayList<writeboardDTO> temp = new ArrayList<>();

			writeboardDAO dao = new writeboardDAO();

			temp = dao.allViewWriteboard();

			request.setAttribute("allViewWriteboards", temp);
			// 사용자 페이지 이동
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 게시판 한 개 삭제
		} else if (result.equals("deleteWriteboardServiceCon")) {
			sc = new deleteWriteboardServiceCon();
			// 게시판 수정
		} else if (result.equals("updateWriteboardServiceCon")) {
			writeboardDAO dao = new writeboardDAO();
			ArrayList<writeboardDTO> temp = new ArrayList<>();

			int w_key = Integer.parseInt(request.getParameter(""));
			String w_title = request.getParameter("");
			String w_content = request.getParameter("");
			String w_file1 = request.getParameter("");
			String w_file2 = request.getParameter("");

			temp = dao.updateWriteboard(new writeboardDTO(w_key, w_title, w_content, w_file1, w_file2));
			
			request.setAttribute("updateWriteboard", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 댓글 작성
		} else if (result.equals("commentServiceCon")) {
			ArrayList<commentDTO> temp = new ArrayList<>();
			commentDAO dao = new commentDAO();

			int w_key = Integer.parseInt(request.getParameter(""));
			int m_key = Integer.parseInt(request.getParameter(""));
			String c_comment = request.getParameter("");

			temp = dao.comment(new commentDTO(w_key, m_key, c_comment));

			request.setAttribute("comment", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 댓글 삭제
		} else if (result.equals("deleteCommentServiceCon")) {
			sc = new deleteCommentServiceCon();
			// 댓글 수정
		} else if (result.equals("updateCommentServiceCon")) {
			ArrayList<commentDTO> temp = new ArrayList<>();
			commentDAO dao = new commentDAO();

			int c_key = Integer.parseInt(request.getParameter(""));
			String c_content = request.getParameter("");

			temp = dao.updateComment(new commentDTO(c_key, c_content));

			request.setAttribute("content", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 회원가입
		} else if (result.equals("joinServiceCon")) {
			sc = new joinServiceCon();
			// 로그인
		} else if (result.equals("loginServiceCon")) {
			memberDAO dao = new memberDAO();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			memberDTO loginInfo = dao.login(new memberDTO(id, pw));
			
			request.setAttribute("loginInfo", loginInfo);
			// 사용자 페이지 이동
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 웹 정보 입력
			// 로그 아웃 
		} else if (result.equals("logoutServiceCon")) {
			HttpSession session = request.getSession();
			session.removeAttribute("loginInfo");
			
			path = "main.jsp";
		}
		else if (result.equals("webServiceCon")) {
			sc = new webServiceCon();
			// 웹 정보 전체조회
		} else if (result.equals("viewWebServiceCon")) {
			ArrayList<webDTO> temp = new ArrayList<webDTO>();
			webDAO dao = new webDAO();

			temp = dao.allViewWebs();

			request.setAttribute("allViewWebs", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 셀러 입력
		} else if (result.equals("sellerServiceCon")) {
			sc = new sellerServiceCon();
		}
		// 셀러 전체조회
		else if (result.equals("viewSellerServiceCon")) {
			ArrayList<sellerDTO> temp = new ArrayList<>();
			sellerDAO dao = new sellerDAO();

			temp = dao.allViewSellers();
			// "보낼 이름" , 보낼 데이터
			request.setAttribute("sellers", temp);
			// 사용자 페이지 이동
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 예약 등록
		} else if (result.equals("reserveServiceCon")) {
			sc = new reserveServiceCon();
			// 예약 전체조회
		} else if (result.equals("viewReservesServiceCon")) {
			ArrayList<reservedDTO> temp = new ArrayList<>();
			reservedDAO dao = new reservedDAO();

			temp = dao.allViewReservations();

			request.setAttribute("reservations", temp);
			// 사용자 페이지 이동
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			
			// 상품 전체조회
		}else if(result.equals("productServiceCon")) {
			sc = new productServiceCon();
		}
			else if (result.equals("viewProductServiceCon")) {
		
			ArrayList<productDTO> temp = new ArrayList<>();
			productDAO dao = new productDAO();
			// t_product 테이블 전체 조회 메소드
			temp = dao.allViewProduct();
			// "보낼 이름" , 보낼 데이터
			request.setAttribute("products", temp);
			// 사용자 페이지 이동
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 직구 아이템 전체조회
		} else if (result.equals("viewItemsServiceCon")) {
			ArrayList<itemDTO> temp = new ArrayList<itemDTO>();
			itemDAO dao = new itemDAO();

			temp = dao.allViewItems();
		
			request.setAttribute("allViewItems", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		}
		//해외직구 아이템 등록
			else if (result.equals("itemServiceCon")) {
				sc = new itemServiceCon();
			}
			// 인기차트 상위 10위 조회
		else if (result.equals("viewChartServiceCon")) {
			ArrayList<chartDTO> temp = new ArrayList<chartDTO>();
			chartDAO dao = new chartDAO();

			temp = dao.allViewCountTopTen();

			request.setAttribute("chartTopTen", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 가격변동 입력
		} else if (result.equals("changedPriceServiceCon")) {
			sc = new changedPriceServiceCon();
			// 가격변동 기록 전체조회
		} else if (result.equals("ViewChangedPriceServiceCon")) {
			ArrayList<changedPriceDTO> temp = new ArrayList<>();

			changedPriceDAO dao = new changedPriceDAO();
			// 가격변동 전체조회
			temp = dao.allViewChangedPrice();

			request.setAttribute("allViewChangedPrice", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 알람 전체조회
		} else if (result.equals("viewAlarmServiceCon")) {
			ArrayList<alarmDTO> temp = new ArrayList<>();

			alarmDAO dao = new alarmDAO();
			// 가격변동 전체조회
			temp = dao.allViewAlarm();

			request.setAttribute("allViewAlarm", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
			// 알람 입력
		} else if (result.equals("alarmServiceCon")) {
			sc = new alarmServiceCon();
		} else if (result.equals("basketServiceCon")) {
			sc = new basketServiceCon();
		} else if (result.equals("deleteBasketServiceCon")) {
			sc = new deleteBasketServiceCon();
		} else if (result.equals("p_reviewServiceCon")) {
			sc = new p_reviewServiceCon();
		} else if (result.equals("deleteP_reviewServiceCon")) {
			sc = new deleteP_reviewServiceCon();
		} else if (result.equals("updateP_reviewServiceCon")) {
			sc = new updateP_reviewServiceCon();
		} else if (result.equals("allViewP_reviewServiceCon")) {
			ArrayList<p_reviewDTO> temp = new ArrayList<>();

			p_reviewDAO dao = new p_reviewDAO();
			// 가격변동 전체조회
			temp = dao.allViewP_review();

			request.setAttribute("allViewP_review", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		}else if (result.equals("i_reviewServiceCon")) {
			sc = new i_reviewServiceCon();
		} else if (result.equals("deleteI_reviewServiceCon")) {
			sc = new deleteI_reviewServiceCon();
		} else if (result.equals("updateI_reviewServiceCon")) {
			sc = new updateI_reviewServiceCon();
		} else if (result.equals("allViewI_reviewServiceCon")) {
			ArrayList<i_reviewDTO> temp = new ArrayList<>();

			i_reviewDAO dao = new i_reviewDAO();
			// 가격변동 전체조회
			temp = dao.allViewI_review();

			request.setAttribute("allViewI_review", temp);

			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		}
		
		path = sc.execute(request, response);
		if (path != null) {
			response.sendRedirect(path);
		}
	}

}
