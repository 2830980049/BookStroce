package com.tarena.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.entity.Book;
import com.tarena.entity.Collection;
import com.tarena.service.impl.BookServiceImpl;
import com.tarena.service.impl.CollectionServiceImpl;

public class BookDetailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        String isbn = req.getParameter("isbn");
        String user_id = req.getParameter("user_id");
        BookServiceImpl service = new BookServiceImpl();
        Book book = service.queryBookByIsbn(isbn);
        if (book != null) {
            CollectionServiceImpl s = new CollectionServiceImpl();
            Collection collect = s.query(user_id, isbn);
            if (collect != null) {
                req.setAttribute("mess", true);
            }
            req.setAttribute("book", book);
            req.getRequestDispatcher("detail.jsp").forward(req, resp);
        }
    }
}
