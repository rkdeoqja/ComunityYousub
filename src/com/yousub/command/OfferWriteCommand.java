package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;

public class OfferWriteCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String nick = request.getParameter("nick");
		String boardNo = request.getParameter("boardNo");
		String offerId = request.getParameter("offerId");
		String oContent = request.getParameter("oContent");
		String oUrl;
		if(!request.getParameter("oUrl").equals("")) {
			oUrl = request.getParameter("oUrl");
			
			String[] arrUrl = oUrl.split("/"); 
			oUrl = "https://www.youtube.com/embed/"+arrUrl[arrUrl.length-1];
		}else {
			oUrl = "not";
			
		}
		
		DAO dao = new DAO();
		dao.offerWrite(id,nick,boardNo,offerId,oUrl,oContent);
		
	}

	
	
}
