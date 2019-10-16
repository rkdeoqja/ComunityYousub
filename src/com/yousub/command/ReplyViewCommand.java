package com.yousub.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;
import com.yousub.DTO.ReplyDTO;

public class ReplyViewCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String boardNo = request.getParameter("boardNo");
		String bNo = request.getParameter("bNo");
		
		DAO dao = new DAO();
		ArrayList<ReplyDTO> redtos = dao.reView(boardNo, bNo);
		
		request.setAttribute("reDTO", redtos);
		
	}

}
