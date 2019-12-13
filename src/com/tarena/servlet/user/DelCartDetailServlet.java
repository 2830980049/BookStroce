package com.tarena.servlet.user;

import com.tarena.entity.User;
import com.tarena.service.impl.CartDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DelCartDetailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String product = req.getParameter("product");
        CartDetailServiceImpl service = new CartDetailServiceImpl();
        boolean bool=service.delCartDetail(user.getPhone(),product);
        if(bool){
            resp.sendRedirect("CartDetailQuery.do");
        }
    }
}
