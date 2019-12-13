package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.BookDao;
import com.tarena.entity.Book;
import com.tarena.entity.Car;
import com.tarena.entity.PageBean;
import com.tarena.util.DBUtil;

public class BookDaoImpl implements BookDao {

    @Override
    public PageBean<Book> queryPage(int pageCode,
                                    int pageSize) {
        PageBean<Book> bean = new PageBean<>();
        bean.setPageCode(pageCode);
        bean.setPageSize(pageSize);
        int totalCount = getTotalCount();
        bean.setTotalCount(totalCount);
        String sql = "select * from tb_book limit ?,?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (pageCode - 1) * pageSize);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setEdition(rs.getInt("edition"));
                book.setForm(rs.getString("form"));
                book.setFormat(rs.getString("format"));
                book.setPackaging(rs.getString("packaging"));
                book.setPages(rs.getInt("pages"));
                book.setPress(rs.getString("press"));
                book.setPrice(rs.getDouble("price"));
                book.setPublished(rs.getDate("published"));
                book.setTitle(rs.getString("title"));
                book.setWords(rs.getInt("words"));
                list.add(book);
            }
            bean.setListBean(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public int getTotalCount() {
        Connection conn = DBUtil.getConnection();
        String sql = "select count(*) from tb_book";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return num;
    }

    @Override
    public PageBean<Book> searchQuery(int pageCode,
                                      int pageSize, String title) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tb_book where"
                + " title like ? limit ?,?";
        PageBean<Book> bean = new PageBean<>();
        bean.setPageCode(pageCode);
        bean.setPageSize(pageSize);
        bean.setTotalCount(getLikeQueryCount(title));
        List<Book> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");
            ps.setInt(2, (pageCode - 1) * pageSize);
            ps.setInt(3, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setEdition(rs.getInt("edition"));
                book.setForm(rs.getString("form"));
                book.setFormat(rs.getString("format"));
                book.setPackaging(rs.getString("packaging"));
                book.setPages(rs.getInt("pages"));
                book.setPress(rs.getString("press"));
                book.setPrice(rs.getDouble("price"));
                book.setPublished(rs.getDate("published"));
                book.setTitle(rs.getString("title"));
                book.setWords(rs.getInt("words"));
                list.add(book);
            }
            bean.setListBean(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public int getLikeQueryCount(String title) {
        String sql = "select * from tb_book where"
                + " title like ?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return count;
    }

    @Override
    public Book queryBookById(String isbn) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tb_book where isbn=?";
        Book book = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, isbn);
            rs = ps.executeQuery();
            while (rs.next()) {
                book = new Book();
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setEdition(rs.getInt("edition"));
                book.setForm(rs.getString("form"));
                book.setFormat(rs.getString("format"));
                book.setPackaging(rs.getString("packaging"));
                book.setPages(rs.getInt("pages"));
                book.setPress(rs.getString("press"));
                book.setPrice(rs.getDouble("price"));
                book.setPublished(rs.getDate("published"));
                book.setTitle(rs.getString("title"));
                book.setWords(rs.getInt("words"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return book;
    }

    @Override
    public int saveCar(Car car) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into tb_cart_item(user_id,product,count) "
                + "values(?,?,?)";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, car.getUser_id());
            ps.setString(2, car.getPruduct());
            ps.setInt(3, car.getCount());
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return num;
    }

    @Override
    public Car QueryCart(Car car) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tb_cart_item where user_id=? and product=?";
        Car c = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, car.getUser_id());
            ps.setString(2, car.getPruduct());
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Car();
                c.setRid(rs.getInt("rid"));
                c.setUser_id(rs.getString("user_id"));
                c.setPruduct(rs.getString("product"));
                c.setCount(rs.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return c;
    }

    @Override
    public int updateCartCount(Car car) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "update tb_cart_item set count=? where user_id=? and product=?";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, car.getCount());
            ps.setString(2, car.getUser_id());
            ps.setString(3, car.getPruduct());
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return num;
    }
}
