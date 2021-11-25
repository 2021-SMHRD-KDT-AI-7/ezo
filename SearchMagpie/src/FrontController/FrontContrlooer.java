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
		System.out.println(result);

		String path = null;
		Command sc = null;
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		if (result.equals("writeboardServiceCon.do")) {
			sc = new writeboardServiceCon();
		} else if (result.equals("viewWriteboardServiceCon.do")) {
			ArrayList<writeboardDTO> temp = new ArrayList<>();
			writeboardDAO dao = new writeboardDAO();
			temp = dao.allViewWriteboard();
			request.setAttribute("allViewWriteboards.do", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("deleteWriteboardServiceCon.do")) {
			sc = new deleteWriteboardServiceCon();
		} else if (result.equals("updateWriteboardServiceCon.do")) {
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
		} else if (result.equals("commentServiceCon.do")) {
			ArrayList<commentDTO> temp = new ArrayList<>();
			commentDAO dao = new commentDAO();
			int w_key = Integer.parseInt(request.getParameter(""));
			int m_key = Integer.parseInt(request.getParameter(""));
			String c_comment = request.getParameter("");
			temp = dao.comment(new commentDTO(w_key, m_key, c_comment));
			request.setAttribute("comment", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("deleteCommentServiceCon.do")) {
			sc = new deleteCommentServiceCon();
		} else if (result.equals("updateCommentServiceCon.do")) {
			ArrayList<commentDTO> temp = new ArrayList<>();
			commentDAO dao = new commentDAO();
			int c_key = Integer.parseInt(request.getParameter(""));
			String c_content = request.getParameter("");
			temp = dao.updateComment(new commentDTO(c_key, c_content));
			request.setAttribute("content", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("joinServiceCon.do")) {
			sc = new joinServiceCon();
		} else if (result.equals("loginServiceCon.do")) {
			memberDAO dao = new memberDAO();
			String id = request.getParameter("m_id");
			String pw = request.getParameter("m_pw");
			System.out.println("입력 : " + id + pw);
			memberDTO info = dao.login(new memberDTO(id, pw));
			request.setAttribute("info", info);
			RequestDispatcher rd = request.getRequestDispatcher("Main.jsp");
			rd.forward(request, response);
		} else if (result.equals("logoutServiceCon.do")) {
			HttpSession session = request.getSession();
			session.removeAttribute("info");
			path = "Main.jsp";
		} else if (result.equals("updateMemberServiceCon.do")) {
			sc = new updateMemberServiceCon();
		} else if (result.equals("findIdServiceCon.do")) {
			sc = new findIdServiceCon();
			response.sendRedirect("#");
		} else if (result.equals("webServiceCon.do")) {
			sc = new webServiceCon();
		} else if (result.equals("viewWebServiceCon.do")) {
			ArrayList<webDTO> temp = new ArrayList<webDTO>();
			webDAO dao = new webDAO();
			temp = dao.allViewWebs();
			request.setAttribute("allViewWebs", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("sellerServiceCon.do")) {
			sc = new sellerServiceCon();
		} else if (result.equals("viewSellerServiceCon.do")) {
			ArrayList<sellerDTO> temp = new ArrayList<>();
			sellerDAO dao = new sellerDAO();
			temp = dao.allViewSellers();
			request.setAttribute("sellers", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("reserveServiceCon.do")) {
			sc = new reserveServiceCon();
		} else if (result.equals("viewReservesServiceCon.do")) {
			ArrayList<reservedDTO> temp = new ArrayList<>();
			reservedDAO dao = new reservedDAO();
			temp = dao.allViewReservations();
			request.setAttribute("reservations", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("productServiceCon.do")) {
			sc = new productServiceCon();
		} else if (result.equals("allViewProductServiceCon.do")) {
			ArrayList<productDTO> temp = new ArrayList<>();
			productDAO dao = new productDAO();
			temp = dao.allViewProduct();
			request.setAttribute("products", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("viewItemServiceCon.do")) {
			ArrayList<itemDTO> temp = new ArrayList<itemDTO>();
			itemDAO dao = new itemDAO();
			temp = dao.allViewItem();
			request.setAttribute("allViewItems", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("itemServiceCon.do")) {
			sc = new itemServiceCon();
		} else if (result.equals("viewChartServiceCon.do")) {
			ArrayList<chartDTO> temp = new ArrayList<chartDTO>();
			chartDAO dao = new chartDAO();
			temp = dao.allViewCountTopTen();
			request.setAttribute("chartTopTen", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("changedPriceServiceCon.do")) {
			sc = new changedPriceServiceCon();
		} else if (result.equals("ViewChangedPriceServiceCon.do")) {
			ArrayList<changedPriceDTO> temp = new ArrayList<>();
			changedPriceDAO dao = new changedPriceDAO();
			temp = dao.allViewChangedPrice();
			request.setAttribute("allViewChangedPrice", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("viewAlarmServiceCon.do")) {
			ArrayList<alarmDTO> temp = new ArrayList<>();
			alarmDAO dao = new alarmDAO();
			temp = dao.allViewAlarm();
			request.setAttribute("allViewAlarm", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("alarmServiceCon.do")) {
			sc = new alarmServiceCon();
		} else if (result.equals("basketServiceCon.do")) {
			sc = new basketServiceCon();
		} else if (result.equals("deleteBasketServiceCon.do")) {
			sc = new deleteBasketServiceCon();
		} else if (result.equals("allViewBasketServiceCon.do")) {
			ArrayList<basketDTO> temp = new ArrayList<>();
			basketDAO dao = new basketDAO();
			int m_key = Integer.parseInt(request.getParameter("m_key"));
			temp = dao.allViewBasket(new basketDTO(m_key));
			request.setAttribute("comment", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("p_reviewServiceCon.do")) {
			sc = new p_reviewServiceCon();
		} else if (result.equals("deleteP_reviewServiceCon.do")) {
			sc = new deleteP_reviewServiceCon();
		} else if (result.equals("updateP_reviewServiceCon.do")) {
			sc = new updateP_reviewServiceCon();
		} else if (result.equals("allViewP_reviewServiceCon.do")) {
			ArrayList<p_reviewDTO> temp = new ArrayList<>();
			p_reviewDAO dao = new p_reviewDAO();
			temp = dao.allViewP_review();
			request.setAttribute("allViewP_review", temp);
			RequestDispatcher rd = request.getRequestDispatcher("#");
			rd.forward(request, response);
		} else if (result.equals("i_reviewServiceCon.do")) {
			sc = new i_reviewServiceCon();
		} else if (result.equals("deleteI_reviewServiceCon.do")) {
			sc = new deleteI_reviewServiceCon();
		} else if (result.equals("updateI_reviewServiceCon.do")) {
			sc = new updateI_reviewServiceCon();
		} else if (result.equals("allViewI_reviewServiceCon.do")) {
			ArrayList<i_reviewDTO> temp = new ArrayList<>();
			i_reviewDAO dao = new i_reviewDAO();
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
