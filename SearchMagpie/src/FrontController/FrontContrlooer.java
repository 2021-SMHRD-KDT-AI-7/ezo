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
      System.out.println("FrontController");
      HttpSession session = request.getSession();
      String reqURI = request.getRequestURI();
      String project = request.getContextPath();
      String result = reqURI.substring(project.length() + 1);
      System.out.println(result);
      String path = null;
      Command sc = null;      
      
      if (result.equals("writeboardServiceCon.do")) {
         sc = new writeboardServiceCon();
      } else if (result.equals("deleteWriteboardServiceCon.do")) {
         sc = new deleteWriteboardServiceCon();
      } else if (result.equals("updateWriteboardServiceCon.do")) {
         sc = new writeboardServiceCon();   
      } else if (result.equals("deleteCommentServiceCon.do")) {
         sc = new deleteCommentServiceCon();
      }else if (result.equals("joinServiceCon.do")) {
         sc = new joinServiceCon();
      }else if (result.equals("loginServiceCon.do")) {
         sc = new loginServiceCon();
      }else if (result.equals("logoutServiceCon.do")) {
         sc = new logoutServiceCon();
      }else if (result.equals("updateMemberServiceCon.do")) {
         sc = new updateMemberServiceCon();
      } else if (result.equals("findIdServiceCon.do")) {
         sc = new findIdServiceCon();
      } else if (result.equals("webServiceCon.do")) {
         sc = new webServiceCon();
      }else if (result.equals("sellerServiceCon.do")) {
         sc = new sellerServiceCon();
      }else if (result.equals("reserveServiceCon.do")) {
         sc = new reserveServiceCon();
      }else if (result.equals("productServiceCon.do")) {
         sc = new productServiceCon();
      }else if (result.equals("itemServiceCon.do")) {
         sc = new itemServiceCon();
      }else if (result.equals("changedPriceServiceCon.do")) {
         sc = new changedPriceServiceCon();
      }else if (result.equals("alarmServiceCon.do")) {
         sc = new alarmServiceCon();
      } else if (result.equals("basketServiceCon.do")) {
         sc = new basketServiceCon();
      } else if (result.equals("deleteBasketServiceCon.do")) {
         sc = new deleteBasketServiceCon();
      } else if (result.equals("p_reviewServiceCon.do")) {
         sc = new p_reviewServiceCon();
      } else if (result.equals("deleteP_reviewServiceCon.do")) {
         sc = new deleteP_reviewServiceCon();
      } else if (result.equals("updateP_reviewServiceCon.do")) {
         sc = new updateP_reviewServiceCon();
      }else if (result.equals("i_reviewServiceCon.do")) {
         sc = new i_reviewServiceCon();
      } else if (result.equals("deleteI_reviewServiceCon.do")) {
         sc = new deleteI_reviewServiceCon();
      } else if (result.equals("updateI_reviewServiceCon.do")) {
         sc = new updateI_reviewServiceCon(); 
      }   path = sc.execute(request, response);
         response.sendRedirect(path);
      
      
   }
}

