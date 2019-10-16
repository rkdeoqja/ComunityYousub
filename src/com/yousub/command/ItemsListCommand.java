package com.yousub.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yousub.DAO.DAO;
import com.yousub.DTO.ItemsDTO;

public class ItemsListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		DAO dao = new DAO();
		ArrayList<ItemsDTO> idtos = dao.iList();
		
		request.setAttribute("items", idtos);
		
	}

}
