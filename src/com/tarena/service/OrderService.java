package com.tarena.service;

import com.tarena.entity.*;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    boolean saveOrder(Order order);

    List<OrderMess> queryOrderMess(String order_id);

    boolean updateOrder(int address_id, double payment, String placed, String order_id);

    List<Order> queryOrderList();

    OrderDetailHead queryOrderDetailHead(String order_id);

    List<OrderDetailTail> queryOrderDetailTail(String order_id);

    boolean updateOrderStap(String order_id, String sta, String receipt);

    boolean updateOrderStaf(String order_id, String sta, String deliver);

    boolean updateOrderStaj(String order_id, String sta, String handover);

    List<Order> queryOrderClassify(String sta);
}
