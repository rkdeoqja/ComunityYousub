package com.yousub.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.command.BListCommand;
import com.yousub.command.BelieveDeleteCommand;
import com.yousub.command.BelieveViewCommand;
import com.yousub.command.BelieveWriteCommand;
import com.yousub.command.BestReplyCommand;
import com.yousub.command.Command;
import com.yousub.command.IdCheckCommand;
import com.yousub.command.InfoChangeCommand;
import com.yousub.command.ItemsListCommand;
import com.yousub.command.ItemsWriteCommand;
import com.yousub.command.JoinCommand;
import com.yousub.command.LoginCommand;
import com.yousub.command.LogoutCommand;
import com.yousub.command.MemberInfoCommand;
import com.yousub.command.NewReplyCommand;
import com.yousub.command.OfferListCommand;
import com.yousub.command.OfferViewCommand;
import com.yousub.command.OfferWriteCommand;
/*import com.yousub.command.OfferViewCommand;
import com.yousub.command.OfferWriteCommand;*/
import com.yousub.command.ReplyAddCommand;
import com.yousub.command.ReplyDeleteCommand;
import com.yousub.command.ReplyHateCommand;
import com.yousub.command.ReplyHitCommand;
import com.yousub.command.ReplyViewCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("doPost");
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage=null;
		
		Command command=null;
		
		String uri = request.getRequestURI();
		System.out.println("URI: "+uri);
		
		String[] arrURI = uri.split("/");
		String comm = arrURI[arrURI.length-1];
		System.out.println("comm: "+comm);
		
		
		if(comm.equals("join.do")) {
			command = new JoinCommand();
			command.execute(request, response);
			viewPage = "mainPage.do";
			
		}else if(comm.equals("logIn.do")) {
			command = new LoginCommand();
			command.execute(request, response);
			
			
			if(LoginCommand.getX()==1) {
				viewPage="mainPage.do";
			
			}else if(LoginCommand.getX()==0) {
				
				viewPage="loginPage.do";
			}
			
			
		}else if(comm.equals("idCheck.do")) {
			command = new IdCheckCommand();
			command.execute(request, response);
			String whatId = request.getParameter("id");
			System.out.println(whatId);
			viewPage="idCheck.jsp";
			
		
		}else if(comm.equals("logout.do")) {
			command = new LogoutCommand();
			command.execute(request, response);
			viewPage="mainPage.do";
		}else if(comm.equals("memberInfo.do")) {
			command = new MemberInfoCommand();
			command.execute(request, response);
			viewPage = "memberInfoPage.do";
		}else if(comm.equals("infoChange.do")) {
			command = new InfoChangeCommand();
			command.execute(request, response);
			if(InfoChangeCommand.isPwModify()) {
				viewPage="loginPage.do";
			}else {
				viewPage="mainPage.do";
			}
		}else if(comm.equals("memberDelete.do")) {
			
		}else if(comm.equals("believeWrite.do")) {
			command= new BelieveWriteCommand();
			command.execute(request, response);
			viewPage="believePage.do";
			
		}else if(comm.equals("believeWritePage.do")) {
			command = new MemberInfoCommand();
			command.execute(request, response);
			viewPage="board/believeWrite.jsp";
		}else if(comm.equals("loginPage.do")) {
			viewPage="member/login.jsp";
		}else if(comm.equals("mainPage.do")) {
			command = new BestReplyCommand();
			command.execute(request, response);
			command = new NewReplyCommand();
			command.execute(request, response);
			viewPage="main.jsp";
		}else if(comm.equals("joinPage.do")) {
			viewPage="member/join.jsp";
		}else if(comm.equals("believePage.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage="board/believe.jsp";
		}else if(comm.equals("memberInfoPage.do")) {
			viewPage="member/memberInfo.jsp";
		}else if(comm.equals("believeView.do")) {
			command = new BelieveViewCommand();
			command.execute(request, response);
			command = new ReplyViewCommand();
			command.execute(request, response);
			viewPage="believeViewPage.do";
		}else if(comm.equals("believeViewPage.do")) {
			viewPage="board/believeView.jsp";
		}else if(comm.equals("believeDelete.do")) {
			command = new BelieveDeleteCommand();
			command.execute(request, response);
			viewPage= "believePage.do";
			
		}else if(comm.equals("replyAdd.do")) {
			command = new ReplyAddCommand();
			command.execute(request, response);
		
			viewPage= "believeView.do";
		}else if(comm.equals("reHitUp.do")) {
			command = new ReplyHitCommand();
			command.execute(request, response);
			String bNo = request.getParameter("bNo");
			String boardNo = request.getParameter("boardNo");
			viewPage="believeView.do?bNo="+bNo+"&boardNo="+boardNo;
		}else if(comm.equals("reHateUp.do")) {
			command = new ReplyHateCommand();
			command.execute(request, response);
			String bNo = request.getParameter("bNo");
			String boardNo = request.getParameter("boardNo");
			viewPage="believeView.do?bNo="+bNo+"&boardNo="+boardNo;
		}else if(comm.equals("reDelete.do")) {
			command = new ReplyDeleteCommand();
			command.execute(request, response);
			String bNo = request.getParameter("bNo");
			String boardNo = request.getParameter("boardNo");
			viewPage="believeView.do?bNo="+bNo+"&boardNo="+boardNo;
			
		}else if(comm.equals("itemsPage.do")){
			command = new ItemsListCommand();
			command.execute(request, response);
			viewPage = "board/items.jsp";
		}else if(comm.contentEquals("itemsWrite.do")) {
			command = new ItemsWriteCommand();
			command.execute(request, response);
			viewPage="itemsPage.do";
		}else if(comm.equals("itemsWritePage.do")) {
			viewPage = "board/itemsWrite.jsp";
		}else if(comm.contentEquals("offerPage.do")) {
			command = new OfferListCommand();
			command.execute(request, response);
			viewPage = "board/offer.jsp";
		}else if(comm.equals("offerWritePage.do")) {
			viewPage="board/offerWrite.jsp";
		}
		
		else if(comm.equals("offerWrite.do")) {
			command = new OfferWriteCommand(); 
			command.execute(request, response);
			
			viewPage ="offerPage.do";
		}else if(comm.equals("offerView.do")) {
			command = new OfferViewCommand(); 
			command.execute(request, response);
			
			viewPage = "offerViewPage.do";
		}
		
		else if(comm.equals("offerViewPage.do")){
			viewPage = "board/offerView.jsp";
		}else if(comm.equals("backPage.do")) {
			viewPage ="board/back.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}

}
