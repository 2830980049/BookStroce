package com.tarena.dao;

import com.tarena.entity.Address;

import java.util.List;

public interface AddressDao {
    List<Address> queryAddressUser(String user_id);
}
