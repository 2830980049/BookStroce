package com.tarena.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.entity.Book;
import com.tarena.entity.PageBean;
import com.tarena.service.impl.BookServiceImpl;

public class SearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        String page = req.getParameter("page");
        BookServiceImpl service = new BookServiceImpl();
        if (null != page && null != title) {
            int pageCode = Integer.parseInt(page);
            PageBean<Book> pageBean = service.searchQuery(pageCode, 1, title);
            req.setAttribute("pageBean", pageBean);
        } else if (page == null) {
            PageBean<Book> pageBean = service.searchQuery(1, 1, title);
            req.setAttribute("pageBean", pageBean);
        }
        req.setAttribute("title", title);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }
}
