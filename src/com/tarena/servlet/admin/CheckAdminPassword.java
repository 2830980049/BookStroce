package com.tarena.servlet.admin;
import com.tarena.dao.impl.AdminDaoImpl;
import com.tarena.entity.Admin;
import com.tarena.entity.User;
import com.tarena.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckAdminPassword extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        String name =  admin.getAdmin_name();
        //String name = request.getParameter("name");
        //String phone = user.getPhone();
        String pwd =  request.getParameter("upwd");
        AdminServiceImpl service = new AdminServiceImpl();
        boolean flag = service.checkpassword(name,pwd);
        response.getWriter().write(flag+"");
    }
}
