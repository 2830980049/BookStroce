package com.tarena.servlet.admin;

import com.tarena.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveOrderStaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;Charset=UTF-8");
        String order_id = req.getParameter("order_id");
        String sta = req.getParameter("optionsRadios");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(date);
        OrderServiceImpl service = new OrderServiceImpl();
        boolean bool = false;
        if (sta.equals("处理中")) {
            bool = service.updateOrderStap(order_id, sta, format);
        } else if (sta.equals("已发货")) {
            bool = service.updateOrderStaf(order_id, sta, format);
        } else {
            bool = service.updateOrderStaj(order_id, sta, format);
        }
        if (bool) {
            req.getRequestDispatcher("orderClassify.do?sta=" + sta).forward(req, resp);
        } else {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
