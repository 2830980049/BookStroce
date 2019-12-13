package com.tarena.dao;

import com.tarena.entity.Book;
import com.tarena.entity.Car;
import com.tarena.entity.PageBean;

public interface BookDao {
    PageBean<Book> queryPage(int pageCode, int pageSize);

    PageBean<Book> searchQuery(int pageCode, int pageSize, String title);

    Book queryBookById(String isbn);

    int saveCar(Car car);

    Car QueryCart(Car car);

    int updateCartCount(Car car);
}
