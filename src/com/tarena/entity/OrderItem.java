package com.tarena.entity;

public class OrderItem {
    private int rid;//记录编号
    private String product;//商品编号
    private double price;//价格
    private int count;//数量
    private String order_id;//订单编号

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "rid=" + rid +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
