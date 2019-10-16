package com.yousub.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yousub.DAO.DAO;
import com.yousub.DTO.DTO;

public class MemberInfoCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		
		DAO dao = new DAO();
		ArrayList<DTO> dtos = dao.memberInfo(id);
		
		request.setAttribute("userInfo", dtos);
	}

}
