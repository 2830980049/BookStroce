package com.tarena.dao;

import com.tarena.entity.Order;
import com.tarena.entity.OrderDetailHead;
import com.tarena.entity.OrderDetailTail;
import com.tarena.entity.OrderMess;

import java.util.List;

public interface OrderDao {
    int saveOrder(Order order);

    List<OrderMess> queryOrderMess(String order_id);

    int updateOrder(int address_id, double payment, String placed, String order_id);

    List<Order> queryOrderList();

    OrderDetailHead queryOrderDetailHead(String order_id);

    List<OrderDetailTail> queryOrderDetailTail(String order_id);

    int updateOrderStap(String order_id, String sta, String receipt);//更新接单时间

    int updateOrderStaf(String order_id, String sta, String deliver);//更新发货时间

    int updateOrderStaj(String order_id, String sta, String handover);//更新交付时间

    List<Order> queryOrderClassify(String sta);
}
