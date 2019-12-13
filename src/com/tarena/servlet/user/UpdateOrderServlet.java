package com.tarena.servlet.user;

import com.tarena.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UpdateOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int address_id = Integer.parseInt(req.getParameter("address_id"));
        double payment = Double.parseDouble(req.getParameter("payment"));
        String order_id = req.getParameter("order_id");
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String placed = formatter.format(date);
        OrderServiceImpl service = new OrderServiceImpl();
        boolean bool = service.updateOrder(address_id, payment, placed, order_id);
        if (bool) {
            req.setAttribute("order_id", order_id);
            req.setAttribute("payment", payment);
            req.getRequestDispatcher("pay-success.jsp").forward(req, resp);
        }
    }
}
