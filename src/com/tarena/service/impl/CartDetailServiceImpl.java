package com.tarena.service.impl;

import com.tarena.dao.impl.CartDetailDaoImpl;
import com.tarena.entity.CartDetail;
import com.tarena.service.CartDetailService;

import java.util.List;

public class CartDetailServiceImpl implements CartDetailService {
    private CartDetailDaoImpl Dao = null;

    public CartDetailServiceImpl() {
        Dao = new CartDetailDaoImpl();
    }

    @Override
    public List<CartDetail> queryAll(String user_id) {
        if (null != user_id && !"".equals(user_id)) {
            List<CartDetail> list = Dao.queryAllByUser(user_id);
            return list;
        }
        return null;
    }

    @Override
    public boolean delCartDetail(String user_id, String product) {
        if (null != user_id && !"".equals(user_id) && null != product && !"".equals(product)) {
            int num = Dao.delCartDetail(user_id, product);
            if (num > 0) {
                return true;
            }
        }
        return false;
    }
}
