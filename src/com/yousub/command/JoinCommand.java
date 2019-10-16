package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;

public class JoinCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
			String id= request.getParameter("id");
			String pw =request.getParameter("pw");
			String nick = request.getParameter("nick");
			String name =request.getParameter("name");
			String email = request.getParameter("email");
			String pwhint = request.getParameter("pwhint");
			
			DAO dao = new DAO();
			dao.memberJoin(id, pw, nick, name, email, pwhint);
	}

}
