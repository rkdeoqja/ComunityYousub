package com.yousub.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;
import com.yousub.DTO.BelieveDTO;

public class BListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = new DAO();
		ArrayList<BelieveDTO> bdtos = dao.bList();
		
		request.setAttribute("believe", bdtos);
	}

}
