package com.tarena.servlet.admin;

import com.tarena.entity.OrderDetailHead;
import com.tarena.entity.OrderDetailTail;
import com.tarena.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LookOrderDetailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String order_id = req.getParameter("order_id");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(date);
        OrderServiceImpl service = new OrderServiceImpl();
        OrderDetailHead detailHead = service.queryOrderDetailHead(order_id);
        List<OrderDetailTail> detailTails = service.queryOrderDetailTail(order_id);
        req.setAttribute("detailTails", detailTails);
        req.setAttribute("detailHead", detailHead);
        req.setAttribute("format", format);
        req.getRequestDispatcher("order-detail.jsp").forward(req, resp);
    }
}
