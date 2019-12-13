package com.tarena.servlet.admin;

import com.tarena.entity.Order;
import com.tarena.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryOrderClassifyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;Charset=UTF-8");
        String sta = req.getParameter("sta");
        OrderServiceImpl service = new OrderServiceImpl();
        List<Order> orders = service.queryOrderClassify(sta);
        if (orders != null) {
            req.setAttribute("orders", orders);
            req.getRequestDispatcher("orderclassify-list.jsp").forward(req, resp);
        }
    }
}
