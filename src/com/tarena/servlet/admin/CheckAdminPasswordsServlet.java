package com.tarena.servlet.admin;
import javax.servlet.ServletException;
import  javax.servlet.http.*;
import java.io.IOException;

public class CheckAdminPasswordsServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String upwd =  request.getParameter("upwd");
        String upwd1 =  request.getParameter("upwd1");
        boolean flag = false;
        if(upwd.equals(upwd1))
            flag = true;
        response.getWriter().write(flag+"");
    }
}
