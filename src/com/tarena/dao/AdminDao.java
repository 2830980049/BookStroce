package com.tarena.dao;

import com.tarena.entity.Admin;
import com.tarena.entity.Admin_Book;

import java.util.List;

public interface AdminDao {
    Admin queryAdmin(String id, String password);

    int updateAdmin(String id, String upwd);

    Admin checkpassword(String id);

    int insertBook(Admin_Book admin_Book);

    boolean checkBook(String isbn);

    List<Admin_Book> queryBook();

    Admin_Book editBook(String isbn);

    int updatePrice(String isbn, double price);
}
