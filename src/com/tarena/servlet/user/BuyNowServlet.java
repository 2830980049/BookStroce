package com.tarena.servlet.user;

import com.tarena.entity.*;
import com.tarena.service.impl.AddressServiceImpl;
import com.tarena.service.impl.OrderItemServiceImpl;
import com.tarena.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BuyNowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String product = req.getParameter("product");
        double price = Double.parseDouble(req.getParameter("price"));
        int count = Integer.parseInt(req.getParameter("count"));
        User user = (User) req.getSession().getAttribute("user");
        Date date = new Date();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String format1 = dateFormat1.format(date);
        String order_id = user.getPhone().substring(8) + format1;

        Order ord = new Order();
        ord.setOrder_id(order_id);
        ord.setUser_id(user.getPhone());
        ord.setSta("待处理");

        OrderServiceImpl orderService = new OrderServiceImpl();
        boolean flag = orderService.saveOrder(ord);
        if (flag) {
            OrderItem order = new OrderItem();
            order.setProduct(product);
            order.setPrice(price);
            order.setCount(count);
            order.setOrder_id(order_id);

            OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
            boolean bool = orderItemService.saveOrderItem(order);
            if (bool) {
                AddressServiceImpl addressService = new AddressServiceImpl();
                List<Address> list = addressService.queryAddressUser(user.getPhone());
                req.setAttribute("list", list);
                List<OrderMess> listOrder = orderService.queryOrderMess(order_id);
                req.setAttribute("listOrder",listOrder);
                req.getRequestDispatcher("order-confirm.jsp").forward(req, resp);
            }
        }
    }
}
