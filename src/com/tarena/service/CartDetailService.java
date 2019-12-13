package com.tarena.service;

import com.tarena.entity.CartDetail;

import java.util.List;

public interface CartDetailService {
    List<CartDetail> queryAll(String user_id);

    boolean delCartDetail(String user_id, String product);
}
