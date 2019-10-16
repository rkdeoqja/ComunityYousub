package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yousub.DAO.DAO;

public class InfoChangeCommand implements Command{

	static boolean isPwModify = false;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		System.out.println("세션아이디 :"+session.getAttribute("id")+",String id :"+id);
		String pw = request.getParameter("pw");
		DAO dao = new DAO();
		isPwModify = dao.infoChange(id,pw);
		if(isPwModify) {
			request.getSession().invalidate();
		}
		
		
	}
	public static boolean isPwModify() {
		return isPwModify;
	}
	public static void setPwModify(boolean isPwModify) {
		InfoChangeCommand.isPwModify = isPwModify;
	}
	

}
