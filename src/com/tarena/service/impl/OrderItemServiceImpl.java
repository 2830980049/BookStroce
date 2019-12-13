package com.tarena.service.impl;

import com.tarena.dao.OrderItemDao;
import com.tarena.dao.impl.OrderItemDaoImpl;
import com.tarena.entity.OrderItem;
import com.tarena.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDaoImpl dao = null;

    public OrderItemServiceImpl() {
        dao = new OrderItemDaoImpl();
    }

    @Override
    public boolean saveOrderItem(OrderItem order) {
        if (null != order && !"".equals(order)) {
            int num = dao.saveOrderItem(order);
            if (num > 0) {
                return true;
            }
        }
        return false;
    }
}
