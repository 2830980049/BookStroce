package com.tarena.servlet.admin;
import com.tarena.entity.Admin_Book;
import com.tarena.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Admin_EditBookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String isbn = request.getParameter("isbn");
        System.out.println(isbn);
        AdminServiceImpl service = new AdminServiceImpl();
        Admin_Book admin_book = service.editBooks(isbn);
        System.out.println(admin_book);
        if(admin_book!=null){
            HttpSession session = request.getSession();
            session.setAttribute("admin_book",admin_book);
            //request.getAttribute("admin_book");
            response.sendRedirect("product-edit.jsp");
        }
        //request.getRequestDispatcher("product-edit.jsp").forward(request,response);
    }
}
