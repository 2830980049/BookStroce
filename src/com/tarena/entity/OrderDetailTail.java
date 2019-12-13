package com.tarena.entity;

public class OrderDetailTail {
    private int count;//数量
    private String title;//书名
    private String product;//书号
    private double price;//价格

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "OrderDetailTail{" +
                "count=" + count +
                ", title='" + title + '\'' +
                ", product='" + product + '\'' +
                ", price=" + price +
                '}';
    }
}
