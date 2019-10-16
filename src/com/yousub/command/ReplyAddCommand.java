package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;
import com.yousub.DTO.ReplyDTO;

public class ReplyAddCommand implements Command{

	static String stBoardNo;
	static String stBNo;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		String nick = request.getParameter("nick");
		String boardNo = request.getParameter("boardNo");
		String bNo = request.getParameter("bNo");
		String reContent = request.getParameter("reContent");
		
		stBoardNo = boardNo;
		stBNo = bNo;
		
		DAO dao = new DAO();
		dao.replyAdd(id, nick, boardNo, bNo, reContent);
		
	}

	public static String getStBoardNo() {
		return stBoardNo;
	}

	public static void setStBoardNo(String stBoardNo) {
		ReplyAddCommand.stBoardNo = stBoardNo;
	}

	public static String getStBNo() {
		return stBNo;
	}

	public static void setStBNo(String stBNo) {
		ReplyAddCommand.stBNo = stBNo;
	}

}
