package com.tarena.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.service.impl.UserServiceImpl;

public class UserCheckPhoneServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		String phone = req.getParameter("phone");
		UserServiceImpl service = new UserServiceImpl();
		boolean b = service.CheckPhone(phone);
		resp.getWriter().write(b+"");
		
	}
}
