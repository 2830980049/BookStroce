package com.tarena.service;

import com.tarena.entity.Admin;
import com.tarena.entity.Admin_Book;

import java.util.List;

public interface AdminService {
    Admin checkAdmin(String id, String password);
    boolean checkpassword(String name, String pwd);
    boolean updatePassword(String name, String pwd);
    boolean insertBooks(Admin_Book admin_book);
    boolean checkBooks(String isbn);
    List<Admin_Book> queryBooks();
    Admin_Book editBooks(String isbn);
    boolean updatePrice(String isbn, double price);
}
