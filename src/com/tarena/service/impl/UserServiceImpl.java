package com.tarena.service.impl;

import com.tarena.dao.impl.UserDaoImpl;
import com.tarena.entity.User;
import com.tarena.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userdao;

    public UserServiceImpl() {
        userdao = new UserDaoImpl();
    }

    @Override
    public User queryLgin(String name, String pwd, int role) {
        User user = null;
        if (!"".equals(name) && !"".equals(pwd) && name != null && pwd != null) {
            user = userdao.login(name, pwd, role);
        }
        return user;
    }

    @Override
    public boolean CheckName(String name) {
        boolean b = false;
        if (!"".equals(name) && null != name) {
            User user = userdao.queryName(name);
            if (user != null) {
                b = true;
            }
        }
        return b;
    }

    @Override
    public boolean CheckPhone(String phone) {
        boolean b = false;
        if (!"".equals(phone) && null != phone) {
            User user = userdao.queryPhone(phone);
            if (user != null) {
                b = true;
            }
        }
        return b;
    }

    @Override
    public User adminlogin(String uname, String upwd, int role) {
        if(!"".equals(uname) && !"".equals(upwd) && uname !=null && upwd != null){
            User user = userdao.adminlogin(uname, upwd, 1);
            return user;
        }
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        boolean b = false;
        if (user != null) {
            int num = userdao.insertUser(user);
            if (num > 0) {
                b = true;
            }
        }
        return b;
    }

}
