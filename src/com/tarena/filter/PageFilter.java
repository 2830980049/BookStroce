package com.tarena.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.entity.Book;
import com.tarena.entity.PageBean;
import com.tarena.service.impl.BookServiceImpl;

public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig arg0)
            throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        BookServiceImpl service = new BookServiceImpl();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        int page = getPageCode(req);
        PageBean<Book> pageBean = service.pageQuery(page, 4);
        req.setAttribute("pageBean", pageBean);
        chain.doFilter(req, resp);
    }

    public int getPageCode(HttpServletRequest req) {
        String page = req.getParameter("page");
        if (page == null || "1".equals(page)) {
            return 1;
        }
        return Integer.parseInt(page);
    }

    @Override
    public void destroy() {
    }
}
