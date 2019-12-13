package com.tarena.dao.impl;

import com.tarena.dao.OrderDao;
import com.tarena.entity.Order;
import com.tarena.entity.OrderDetailHead;
import com.tarena.entity.OrderDetailTail;
import com.tarena.entity.OrderMess;
import com.tarena.servlet.user.SearchServlet;
import com.tarena.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into tb_order(user_id,order_id,sta) values(?,?,?)";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, order.getUser_id());
            ps.setString(2, order.getOrder_id());
            ps.setString(3, order.getSta());
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
    public List<OrderMess> queryOrderMess(String order_id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select b.isbn,b.title,b.press,b.price,b.edition,o.count " +
                "from tb_book as b " +
                "inner join tb_order_item as o " +
                "on b.isbn=o.product " +
                "where o.order_id=?";
        List<OrderMess> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, order_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderMess order = new OrderMess();
                order.setOrder_id(order_id);
                order.setIsbn(rs.getString("isbn"));
                order.setTitle(rs.getString("title"));
                order.setPrice(rs.getDouble("price"));
                order.setCount(rs.getInt("count"));
                order.setPress(rs.getString("press"));
                order.setEdition(rs.getInt("edition"));
                list.add(order);
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
    public int updateOrder(int address_id, double payment, String placed, String order_id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "update tb_order set address_id=?,payment=?,placed=? " +
                "where order_id=?";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, address_id);
            ps.setDouble(2, payment);
            ps.setString(3, placed);
            ps.setString(4, order_id);
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
    public List<Order> queryOrderList() {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tb_order order by placed desc";
        List<Order> orderless = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrder_id(rs.getString("order_id"));
                order.setSta(rs.getString("sta"));
                order.setPlaced(rs.getString("placed"));
                order.setPayment(rs.getDouble("payment"));
                orderless.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return orderless;
    }

    @Override
    public OrderDetailHead queryOrderDetailHead(String order_id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT o.placed,o.payment,o.sta,a.receiver," +
                "a.address,a.receiver_phone " +
                "FROM tb_order as o " +
                "INNER JOIN tb_address as a " +
                "on o.address_id=a.rid " +
                "WHERE order_id = ?";
        OrderDetailHead detailHead = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, order_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                detailHead = new OrderDetailHead();
                detailHead.setOrder_id(order_id);
                detailHead.setReceiver(rs.getString("receiver"));
                detailHead.setAddress(rs.getString("address"));
                detailHead.setReceiver_phone(rs.getString("receiver_phone"));
                detailHead.setPlaced(rs.getString("placed"));
                detailHead.setPayment(rs.getDouble("payment"));
                detailHead.setSta(rs.getString("sta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return detailHead;
    }

    @Override
    public List<OrderDetailTail> queryOrderDetailTail(String order_id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT o.count,b.title,o.product,o.price " +
                "FROM tb_order_item as o " +
                "INNER JOIN tb_book as b " +
                "on o.product=b.isbn " +
                "WHERE order_id = ?";
        List<OrderDetailTail> detailTails = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, order_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetailTail detailTail = new OrderDetailTail();
                detailTail.setCount(rs.getInt("count"));
                detailTail.setTitle(rs.getString("title"));
                detailTail.setProduct(rs.getString("product"));
                detailTail.setPrice(rs.getDouble("price"));
                detailTails.add(detailTail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return detailTails;
    }

    @Override
    public int updateOrderStap(String order_id, String sta, String receipt) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "update tb_order set sta=?,receipt=? where order_id=?";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, sta);
            ps.setString(2, receipt);
            ps.setString(3, order_id);
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
    public int updateOrderStaf(String order_id, String sta, String deliver) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "update tb_order set sta=?,deliver=? where order_id=?";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, sta);
            ps.setString(2, deliver);
            ps.setString(3, order_id);
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
    public int updateOrderStaj(String order_id, String sta, String handover) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "update tb_order set sta=?,handover=? where order_id=?";
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, sta);
            ps.setString(2, handover);
            ps.setString(3, order_id);
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
    public List<Order> queryOrderClassify(String sta) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tb_order WHERE sta=? order by placed desc";
        List<Order> orderless = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,sta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrder_id(rs.getString("order_id"));
                order.setSta(rs.getString("sta"));
                order.setPlaced(rs.getString("placed"));
                order.setPayment(rs.getDouble("payment"));
                orderless.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(ps);
            DBUtil.closeConnection(conn);
        }
        return orderless;
    }
}
