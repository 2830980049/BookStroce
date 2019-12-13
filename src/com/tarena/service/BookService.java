package com.tarena.service;

import com.tarena.entity.Book;
import com.tarena.entity.Car;
import com.tarena.entity.PageBean;

public interface BookService {
    PageBean<Book> pageQuery(int pageCode, int pageSize);

    PageBean<Book> searchQuery(int pageCode, int pageSize, String title);

    Book queryBookByIsbn(String isbn);

    boolean insertCart(Car car);
}
