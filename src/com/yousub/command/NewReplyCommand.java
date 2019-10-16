package com.yousub.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;
import com.yousub.DTO.ReplyDTO;

public class NewReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		DAO dao = new DAO();
		ArrayList<ReplyDTO> reNdtos= dao.reNew();
		
		request.setAttribute("reNew", reNdtos);
	}

}
