package com.yousub.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;
import com.yousub.DTO.ReplyDTO;

public class BestReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BestReply Command");
		DAO dao = new DAO();
		ArrayList<ReplyDTO> redtos = dao.reBest();
		
		request.setAttribute("ReplyBest", redtos);

		for(int i =0; i<redtos.size();i++) {
			System.out.println("ReplyCommand"+i+"¹øÂ°");
			System.out.println(redtos.get(i).getNick());
			System.out.println(redtos.get(i).getReContent());
			System.out.println(redtos.get(i).getReHit());
		}
		
	}

}
