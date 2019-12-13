package com.tarena.dao.impl;

import com.tarena.dao.CartDetailDao;
import com.tarena.entity.Book;
import com.tarena.entity.CartDetail;
import com.tarena.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDetailDaoImpl implements CartDetailDao {

    @Override
    public List<CartDetail> queryAllByUser(String user_id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select b.title,b.author,b.price,b.edition," +
                "b.press,c.product,c.count " +
                "from tb_book as b " +
                "inner join tb_cart_item as c " +
                "on b.isbn=c.product " +
                "where c.user_id=?";
        List<CartDetail> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                CartDetail cart = new CartDetail();
                cart.setTitle(rs.getString("title"));
                cart.setAuthor(rs.getString("author"));
                cart.setPrice(rs.getInt("price"));
                cart.setCount(rs.getInt("count"));
                cart.setIsbn(rs.getString("product"));
                cart.setPress(rs.getString("press"));
                cart.setEdition(rs.getInt("edition"));
                list.add(cart);
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

    @Override
    public int delCartDetail(String user_id, String product) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from tb_cart_item where user_id=? and product=?";
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
}
