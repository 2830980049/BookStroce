package com.tarena.service.impl;

import com.tarena.dao.impl.AddressDaoImpl;
import com.tarena.entity.Address;
import com.tarena.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDaoImpl dao = null;

    public AddressServiceImpl() {
        dao = new AddressDaoImpl();
    }

    @Override
    public List<Address> queryAddressUser(String user_id) {
        if (null != user_id && !"".equals(user_id)) {
            List<Address> list = dao.queryAddressUser(user_id);
            return list;
        }
        return null;
    }
}
