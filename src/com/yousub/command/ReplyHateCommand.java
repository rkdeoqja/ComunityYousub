package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;

public class ReplyHateCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String reNo = request.getParameter("reNo");
		DAO dao = new DAO();
		dao.upReHate(reNo);
	}

}
