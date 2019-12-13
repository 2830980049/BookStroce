package com.tarena.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.entity.Car;
import com.tarena.service.impl.BookServiceImpl;

public class SaveCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        String user_id = req.getParameter("user_id");
        String product = req.getParameter("product");
        String s_count = req.getParameter("count");
        int count = Integer.parseInt(s_count);
        Car car = new Car();
        car.setUser_id(user_id);
        car.setPruduct(product);
        car.setCount(count);
        BookServiceImpl service = new BookServiceImpl();
        boolean b = service.insertCart(car);
        if (b) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }
}
