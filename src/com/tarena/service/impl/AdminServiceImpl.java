package com.tarena.service.impl;

import com.tarena.dao.impl.AdminDaoImpl;
import com.tarena.entity.Admin;
import com.tarena.entity.Admin_Book;
import com.tarena.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDaoImpl adminDao;
    public AdminServiceImpl(){
        adminDao = new AdminDaoImpl(); //连接数据库及操作
    }
    @Override
    public Admin checkAdmin(String uname,String upwd) {
        Admin admin = null;
        if(null!=uname&&null!=upwd&&!"".equals(uname)&&!"".equals(upwd)){
            admin = adminDao.queryAdmin(uname,upwd);
        }
        return admin;
    }

    @Override
    public boolean checkpassword(String uname,String upwd) {
        boolean flag = false;
        Admin s = adminDao.checkpassword(uname);
        if(s != null && s.getPassword().equals(upwd))
            flag = true;
        return flag;
    }

    @Override
    public boolean updatePassword(String name, String pwd) {
        int cnt;
        cnt = adminDao.updateAdmin(name,pwd);
        if(cnt > 0)
            return true;
        return false;
    }

    @Override
    public boolean insertBooks(Admin_Book admin_book) {
        int cnt;
        cnt = adminDao.insertBook(admin_book);
        if(cnt > 0)
            return true;
        return false;
    }

    @Override
    public boolean checkBooks(String isbn) {
        boolean flag;
        flag = adminDao.checkBook(isbn);
        if(flag)
            return true;
        return false;
    }

    @Override
    public List<Admin_Book> queryBooks() {
        List<Admin_Book> admin_books = adminDao.queryBook();
        return admin_books;
    }

    @Override
    public Admin_Book editBooks(String isbn) {
        Admin_Book admin_book = adminDao.editBook(isbn);
        if(admin_book!=null)
            return admin_book;
        return null;
    }

    @Override
    public boolean updatePrice(String isbn, double price) {
        int cnt = adminDao.updatePrice(isbn,price);
        if(cnt > 0)
            return true;
        return false;
    }


}
