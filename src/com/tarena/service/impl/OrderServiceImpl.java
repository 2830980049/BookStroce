package com.tarena.service.impl;

import com.tarena.dao.impl.OrderDaoImpl;
import com.tarena.entity.*;
import com.tarena.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDaoImpl dao = null;

    public OrderServiceImpl() {
        dao = new OrderDaoImpl();
    }

    @Override
    public boolean saveOrder(Order order) {
        if (null != order && !"".equals(order)) {
            int num = dao.saveOrder(order);
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<OrderMess> queryOrderMess(String order_id) {
        if (null != order_id && !"".equals(order_id)) {
            List<OrderMess> list = dao.queryOrderMess(order_id);
            return list;
        }
        return null;
    }

    @Override
    public boolean updateOrder(int address_id, double payment, String placed, String order_id) {
        if (null != order_id && !"".equals(order_id) && null != placed && !"".equals(placed)) {
            int num = dao.updateOrder(address_id, payment, placed, order_id);
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Order> queryOrderList() {
        List<Order> list = dao.queryOrderList();
        if (null != list && !"".equals(list)) {
            return list;
        }
        return null;
    }

    @Override
    public OrderDetailHead queryOrderDetailHead(String order_id) {
        if (null != order_id && !"".equals(order_id)) {
            OrderDetailHead DetailHead = dao.queryOrderDetailHead(order_id);
            return DetailHead;
        }
        return null;
    }

    @Override
    public List<OrderDetailTail> queryOrderDetailTail(String order_id) {
        if (null != order_id && !"".equals(order_id)) {
            List<OrderDetailTail> detailTails = dao.queryOrderDetailTail(order_id);
            return detailTails;
        }
        return null;
    }

    @Override
    public boolean updateOrderStap(String order_id, String sta, String receipt) {
        if (null != receipt && !"".equals(receipt) && null != order_id && !"".equals(order_id) && null != sta && !"".equals(sta)) {
            int num = dao.updateOrderStap(order_id, sta, receipt);
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateOrderStaf(String order_id, String sta, String deliver) {
        if (null != deliver && !"".equals(deliver) && null != order_id && !"".equals(order_id) && null != sta && !"".equals(sta)) {
            int num = dao.updateOrderStaf(order_id, sta, deliver);
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateOrderStaj(String order_id, String sta, String handover) {
        if (null != handover && !"".equals(handover) && null != order_id && !"".equals(order_id) && null != sta && !"".equals(sta)) {
            int num = dao.updateOrderStaj(order_id, sta, handover);
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Order> queryOrderClassify(String sta) {
        if (null != sta && !"".equals(sta)) {
            List<Order> orders = dao.queryOrderClassify(sta);
            return orders;
        }
        return null;
    }
}
