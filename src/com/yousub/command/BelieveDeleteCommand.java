package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yousub.DAO.DAO;

public class BelieveDeleteCommand implements Command{
	static boolean isSame = false;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String sessionId = session.getAttribute("id").toString();
		String bNo = request.getParameter("bNo");
		
		
		if(id.equals(sessionId)) {
			System.out.println("id:"+id+",sessionId:"+sessionId+",bNo:"+bNo);
			DAO dao = new DAO();
			dao.believeDelete(bNo);
			isSame = true;
			session.setAttribute("bDelete", true);
		}else {
			isSame = false;
			session.setAttribute("bDelete", false);
		}
		
	}
	public static boolean isSame() {
		return isSame;
	}
	public static void setSame(boolean isSame) {
		BelieveDeleteCommand.isSame = isSame;
	}
	
	
}
