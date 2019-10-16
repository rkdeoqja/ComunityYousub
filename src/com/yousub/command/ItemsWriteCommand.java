package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;

public class ItemsWriteCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String nick = request.getParameter("nick");
		String chName = request.getParameter("chName");
		String iContent = request.getParameter("iContent");
		
		DAO dao = new DAO();
		dao.itemWrite(id,nick,chName,iContent);
		
	}

}
