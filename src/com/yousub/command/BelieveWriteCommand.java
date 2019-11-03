package com.yousub.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;

public class BelieveWriteCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id= request.getParameter("id");
		String nick = request.getParameter("nick");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		
		String youtubeUrl = request.getParameter("bUrl");
		
		
		String[] arrUrl = youtubeUrl.split("/"); 
		String bUrl = "https://www.youtube.com/embed/"+arrUrl[arrUrl.length-1];
		
		
		DAO dao = new DAO();
		
		dao.bWrite(id,nick,bTitle,bUrl,bContent);
	}
	
}
