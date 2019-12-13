package com.tarena.dao.impl;

import com.tarena.dao.AdminDao;
import com.tarena.entity.Admin;
import com.tarena.entity.Admin_Book;
import com.tarena.entity.Book;
import com.tarena.util.DBUtil;

import java.lang.String.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin queryAdmin(String uname,String upwd) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from tb_user where uname = ? and upwd=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Admin admin = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,upwd);
            rs = ps.executeQuery();
            while (rs.next()){
                admin =  new Admin();
                admin.setAdmin_name(rs.getString("uname"));
                admin.setPassword(rs.getString("upwd"));
                admin.setRole(rs.getInt("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
        }
        return admin;
    }


    @Override
    public int updateAdmin(String uname,String upwd) {
        Connection conn = DBUtil.getConnection();
        String sql = "update tb_user set upwd=? where uname=?";
        PreparedStatement ps = null;
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,upwd);
            ps.setString(2,uname);
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeStatement(ps);
        }
        return num;
    }


    @Override
    public Admin checkpassword(String id) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from tb_user where uname = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Admin admin = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                admin = new Admin();
                admin.setAdmin_name(rs.getString("uname"));
                admin.setPassword(rs.getString("upwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
        }
        return admin;
    }

    @Override
    public int insertBook(Admin_Book admin_Book) {
        Connection conn =  DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into tb_book values(?,?,?,?,?,?,?,?,?,?,?,?)";
        int num =0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,admin_Book.getIsbn());
            ps.setString(2,admin_Book.getTitle());
            ps.setString(3,admin_Book.getAuthor());
            ps.setDouble(4,admin_Book.getPrice());
            ps.setString(5,admin_Book.getPress());
            ps.setInt(6,admin_Book.getEdition());
            ps.setDate(7,admin_Book.getPublished());
            ps.setInt(8,admin_Book.getPages());
            ps.setInt(9,admin_Book.getWords());
            ps.setString(10,admin_Book.getPackaging());
            ps.setString(11,admin_Book.getFromat());
            ps.setString(12,admin_Book.getForm());
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeStatement(ps);
        }
        return num;
    }

    @Override
    public boolean checkBook(String isbn) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from tb_book where isbn = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = true;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,isbn);
            rs = ps.executeQuery();
            while(rs.next()){
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
        }
        return flag;
    }

    @Override
    public List<Admin_Book> queryBook() {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from tb_book";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Admin_Book> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Admin_Book book = new Admin_Book();
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setPress(rs.getString("press"));
                book.setEdition(rs.getInt("edition"));
                book.setPublished(rs.getDate("published"));
                book.setPages(rs.getInt("pages"));
                book.setWords(rs.getInt("words"));
                book.setPackaging(rs.getString("packaging"));
                book.setFromat(rs.getString("format"));
                book.setForm(rs.getString("form"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
        }
        return list;
    }

    @Override
    public Admin_Book editBook(String isbn) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from tb_book where isbn=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Admin_Book admin_book=null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,isbn);
            rs = ps.executeQuery();
            while(rs.next()){
                admin_book  = new Admin_Book();
                admin_book.setIsbn(rs.getString("isbn"));
                admin_book.setTitle(rs.getString("title"));
                admin_book.setAuthor(rs.getString("author"));
                admin_book.setPrice(rs.getDouble("price"));
                admin_book.setPress(rs.getString("press"));
                admin_book.setEdition(rs.getInt("edition"));
                admin_book.setPublished(rs.getDate("published"));
                admin_book.setPages(rs.getInt("pages"));
                admin_book.setWords(rs.getInt("words"));
                admin_book.setPackaging(rs.getString("packaging"));
                admin_book.setFromat(rs.getString("format"));
                admin_book.setForm(rs.getString("form"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
        }
        return admin_book;
    }

    @Override
    public int updatePrice(String isbn,double price) {
        Connection conn =  DBUtil.getConnection();
        String sql = "update tb_book set price=?  where isbn=?";
        PreparedStatement ps = null;
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,price);
            ps.setString(2,isbn);
            num = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeConnection(conn);
            DBUtil.closeStatement(ps);
        }
        return num;
    }
}
