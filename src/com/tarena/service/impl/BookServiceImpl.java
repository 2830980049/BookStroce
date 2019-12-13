package com.tarena.service.impl;

import com.tarena.dao.impl.BookDaoImpl;
import com.tarena.entity.Book;
import com.tarena.entity.Car;
import com.tarena.entity.PageBean;
import com.tarena.service.BookService;

public class BookServiceImpl implements BookService {

    private BookDaoImpl bookDao = null;

    public BookServiceImpl() {
        bookDao = new BookDaoImpl();
    }

    @Override
    public PageBean<Book> pageQuery(int pageCode, int pageSize) {
        if (pageCode > 0 && pageSize > 0) {
            PageBean<Book> pageBean =
                    bookDao.queryPage(pageCode, pageSize);
            return pageBean;
        }
        return null;
    }

    @Override
    public PageBean<Book> searchQuery(int pageCode, int pageSize, String title) {
        if (pageCode > 0 && pageSize > 0) {
            if (null != title && !"".equals(title)) {
                PageBean<Book> pageBean =
                        bookDao.searchQuery(pageCode, pageSize, title);
                return pageBean;
            }
        }
        return null;
    }

    @Override
    public Book queryBookByIsbn(String isbn) {
        if (null != isbn && !"".equals(isbn)) {
            Book book = bookDao.queryBookById(isbn);
            return book;
        }
        return null;
    }

    @Override
    public boolean insertCart(Car car) {
        if (car != null) {
            Car cart = bookDao.QueryCart(car);
            int num = 0;
            if (cart != null) {
                int count = cart.getCount();
                car.setCount(count + car.getCount());
                num = bookDao.updateCartCount(car);
            } else {
                num = bookDao.saveCar(car);
            }
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

}
