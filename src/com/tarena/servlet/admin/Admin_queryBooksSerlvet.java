package com.tarena.servlet.admin;
import com.tarena.entity.Admin_Book;
import com.tarena.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import  javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class Admin_queryBooksSerlvet extends  HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServiceImpl service = new AdminServiceImpl();
        HttpSession session = request.getSession();
        List<Admin_Book> list =  service.queryBooks();
        session.setAttribute("list",list);
        response.sendRedirect("product-list.jsp");
    }
}
