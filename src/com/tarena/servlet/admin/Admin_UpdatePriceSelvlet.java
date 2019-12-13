package com.tarena.servlet.admin;
import com.tarena.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin_UpdatePriceSelvlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        double price = Double.parseDouble(request.getParameter("price"));
        AdminServiceImpl service = new AdminServiceImpl();
        boolean flag = service.updatePrice(isbn,price);
        System.out.println(isbn+" "+price+" "+flag);
        if(flag){
            response.sendRedirect("queryBooks.do");
        }
        else{

        }
    }
}
