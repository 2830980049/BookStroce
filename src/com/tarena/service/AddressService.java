package com.tarena.service;

import com.tarena.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> queryAddressUser(String user_id);
}
