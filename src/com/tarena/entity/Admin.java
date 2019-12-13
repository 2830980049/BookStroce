package com.tarena.entity;

import java.sql.Date;

public class Admin {
    String password;
    String admin_name;
    int role;

    public int getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "password='" + password + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", role=" + role +
                '}';
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
