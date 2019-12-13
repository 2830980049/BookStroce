package com.tarena.servlet.admin;
import com.tarena.entity.Admin;
import com.tarena.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import  javax.servlet.http.*;
import java.io.IOException;

public class CheckAdminPasswords extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        String name =  admin.getAdmin_name();
        String upwd =  request.getParameter("cnpassword");
        AdminServiceImpl service = new AdminServiceImpl();
        boolean flag;
        flag = service.updatePassword(name,upwd);
        if (flag){
            admin.setPassword(upwd);
            request.setAttribute("admin",admin);
            response.sendRedirect("login.jsp");
        }
        else {
            request.setAttribute("mess", "修改失败，请重新输入!");
            request.getRequestDispatcher("updatePassword.do").forward(request,response);
        }
    }
    }
