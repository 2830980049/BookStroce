package com.tarena.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.service.impl.UserServiceImpl;

public class UserCheckNameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        UserServiceImpl service = new UserServiceImpl();
        boolean b = service.CheckName(name);
        resp.getWriter().write(b + "");
    }
}
