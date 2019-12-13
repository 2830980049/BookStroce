package com.tarena.dao.impl;

import com.tarena.dao.OrderItemDao;
import com.tarena.entity.OrderItem;
import com.tarena.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemDaoImpl implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem order) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into tb_order_item(product,price,count,order_id) " +
                "values(?,?,?,?)";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, order.getProduct());
            ps.setDouble(2, order.getPrice());
            ps.setInt(3, order.getCount());
            ps.setString(4, order.getOrder_id());
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
