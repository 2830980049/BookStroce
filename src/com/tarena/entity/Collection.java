package com.tarena.entity;

public class Collection {
    private int rid;
    private String user_id;
    private String product;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Collection [rid=" + rid + ", user_id=" + user_id + ", product=" + product + "]";
    }
}
