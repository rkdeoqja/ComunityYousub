package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;
import com.yousub.DTO.OfferDTO;

public class OfferViewCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String oNo = request.getParameter("oNo");
		DAO dao = new DAO();
		
		OfferDTO odto = dao.offerView(oNo);
		
		request.setAttribute("oView", odto);
	}

}
