package com.tarena.dao.impl;

import com.tarena.dao.AddressDao;
import com.tarena.entity.Address;
import com.tarena.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Override
    public List<Address> queryAddressUser(String user_id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tb_address where user_id=?";
        List<Address> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Address addr = new Address();
                addr.setRid(rs.getInt("rid"));
                addr.setAddress(rs.getString("address"));
                addr.setAdded(rs.getDate("added"));
                addr.setReceiver(rs.getString("receiver"));
                addr.setReceiver_phone(rs.getString("receiver_phone"));
                addr.setUser_id(rs.getString("user_id"));
                list.add(addr);
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
