package com.tarena.entity;

public class User {
    private String phone;
    private String uname;
    private String upwd;
    private String email;
    private int role;

    public User() {
    }

    public User(String phone, String uname, String upwd, String email, int role) {
        this.phone = phone;
        this.uname = uname;
        this.upwd = upwd;
        this.email = email;
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [phone=" + phone + ", uname=" + uname + ", upwd=" + upwd + ", email=" + email + ", role=" + role
                + "]";
    }
}
