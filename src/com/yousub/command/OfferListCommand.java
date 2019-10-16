package com.yousub.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;
import com.yousub.DTO.OfferDTO;

public class OfferListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = new DAO();
		ArrayList<OfferDTO> odtos = dao.offerList();
		
		request.setAttribute("offerList", odtos);
	}

}
