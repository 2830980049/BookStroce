package com.tarena.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.entity.User;
import com.tarena.service.impl.UserServiceImpl;

public class UserSaveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("uname");
        String pwd = req.getParameter("upwd");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        User user = new User(phone, name, pwd, email, 0);
        UserServiceImpl service = new UserServiceImpl();
        boolean b = service.saveUser(user);
        if (b) {
            resp.sendRedirect("login.jsp");
        } else {
            req.setAttribute("mess", "注册失败，请重新注册");
            req.getRequestDispatcher("regist.jsp").forward(req, resp);
        }

    }
}
