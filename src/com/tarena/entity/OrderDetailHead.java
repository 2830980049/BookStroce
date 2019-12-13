package com.tarena.entity;

public class OrderDetailHead {
    private String order_id;//订单编号
    private String receiver;//收件人姓名
    private String address;//收货地址
    private String receiver_phone;//电话
    private String placed;//订单创建时间
    private double payment;//订单总额
    private String sta;//订单状态

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getPlaced() {
        return placed;
    }

    public void setPlaced(String placed) {
        this.placed = placed;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getSta() {
        return sta;
    }

    public void setSta(String sta) {
        this.sta = sta;
    }

    @Override
    public String toString() {
        return "OrderDetailHead{" +
                "order_id='" + order_id + '\'' +
                ", receiver='" + receiver + '\'' +
                ", address='" + address + '\'' +
                ", receiver_phone='" + receiver_phone + '\'' +
                ", placed=" + placed +
                ", payment=" + payment +
                ", sta='" + sta + '\'' +
                '}';
    }
}
