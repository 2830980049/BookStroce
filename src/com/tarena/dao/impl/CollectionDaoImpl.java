package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.CollectionDao;
import com.tarena.entity.Book;
import com.tarena.entity.Collection;
import com.tarena.util.DBUtil;

public class CollectionDaoImpl implements CollectionDao {

    @Override
    public Collection query(String user_id, String product) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tb_collect where user_id=? and product=?";
        Collection c = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user_id);
            ps.setString(2, product);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Collection();
                c.setRid(rs.getInt("rid"));
                c.setUser_id(rs.getString("user_id"));
                c.setProduct(rs.getString("product"));
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
    public int saveCollect(String user_id, String product) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into tb_collect(user_id,product) values(?,?)";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user_id);
            ps.setString(2, product);
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
    public int deleteCollect(String user_id, String product) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from tb_collect where user_id=? and product=?";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user_id);
            ps.setString(2, product);
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
    public List<Book> queryCollect(String user_id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tb_book where isbn in"
                + "(select product from tb_collect where user_id=?)";
        List<Book> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user_id);
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return list;
    }

}
