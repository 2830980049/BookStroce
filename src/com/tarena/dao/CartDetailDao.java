package com.tarena.dao;

import com.tarena.entity.CartDetail;

import java.util.List;

public interface CartDetailDao {
    List<CartDetail> queryAllByUser(String user_id);

    int delCartDetail(String user_id, String product);
}
