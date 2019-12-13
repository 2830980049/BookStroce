package com.tarena.servlet.admin;

import com.tarena.entity.Order;
import com.tarena.entity.PageBean;
import com.tarena.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryOrderListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderServiceImpl service = new OrderServiceImpl();
        List<Order> bean = service.queryOrderList();
        req.setAttribute("bean", bean);
        req.getRequestDispatcher("order-list.jsp").forward(req, resp);
    }

}
