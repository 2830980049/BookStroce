package com.tarena.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tarena.entity.User;
import com.tarena.service.impl.UserServiceImpl;

public class UserSerlvet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException,
            IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("uname");
        String pwd = req.getParameter("upwd");
        UserServiceImpl service = new UserServiceImpl();
        User user = service.queryLgin(name, pwd, 0);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("index.jsp");
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
