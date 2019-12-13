package com.tarena.service;

import com.tarena.entity.User;

public interface UserService {
    User queryLgin(String name, String pwd, int role);

    boolean CheckName(String name);

    boolean CheckPhone(String phone);

    User adminlogin(String uname, String upwd, int role);

    boolean saveUser(User user);
}
