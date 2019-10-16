package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;
import com.yousub.DTO.BelieveDTO;

public class BelieveViewCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bNo = request.getParameter("bNo");
		
		DAO dao = new DAO();
		
		BelieveDTO bdto = dao.believeView(bNo);
		
		request.setAttribute("bView", bdto);
		
		
	}

}
