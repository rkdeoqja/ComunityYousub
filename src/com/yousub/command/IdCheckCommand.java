package com.yousub.command;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yousub.DAO.DAO;

public class IdCheckCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		HttpSession session = (HttpSession)request.getSession();
		
		DAO dao = new DAO();
		String finalId = dao.idCheck(id);

		if(finalId=="") {
			finalId=null;
			request.setAttribute("checkId", finalId);
			
		}else {
			
			request.setAttribute("checkId", finalId);
		}
		
		
	}
	
	
	
	
}
