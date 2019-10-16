package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yousub.DAO.DAO;
import com.yousub.DTO.DTO;

public class LoginCommand implements Command{
	static int x;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		DAO dao = new DAO();
		DTO dto = dao.loginCheck(id,pw);
		
		
		String nick = dto.getNick();
		
		if(dto != null) {
		
			session.setAttribute("id", id);
			session.setAttribute("nick", nick);
			x=1;
		}else {
			x= 0;
		}
		
		
		
		
	}
	public static int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	
	

}
