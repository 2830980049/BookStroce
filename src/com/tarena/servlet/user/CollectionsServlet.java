package com.tarena.servlet.user;

import com.tarena.entity.Book;
import com.tarena.entity.User;
import com.tarena.service.impl.CollectionServiceImpl;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CollectionsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String phone = user.getPhone();
        CollectionServiceImpl service = new CollectionServiceImpl();
        List<Book> list = service.queryCollect(phone);
        if (list != null) {
            req.setAttribute("list", list);
            req.getRequestDispatcher("collect.jsp").forward(req, resp);
        }
    }
}
