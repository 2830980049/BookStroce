package com.tarena.servlet.admin;
import com.tarena.entity.Admin;
import com.tarena.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class checkBoosServlet extends  HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String isbn = request.getParameter("isbn");
        AdminServiceImpl service = new AdminServiceImpl();
        boolean flag = service.checkBooks(isbn);
        response.getWriter().write(flag+"");
    }
}
