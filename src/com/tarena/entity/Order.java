package com.tarena.entity;

import java.util.Date;

public class Order {
    private int rid; //'记录编号',
    private String user_id;//'用户编号（用户手机号）',
    private String order_id;//'订单编号（手机号后3位+yyyyMMddHHmm）',
    private String sta;// '订单状态（待处理；处理中；已发货；已交付）',
    private int address_id;//'收货地址',
    private double payment;//'支付金额',
    private String placed;//'下单时间',
    private String receipt;// '接单时间',
    private String deliver;//'发货时间',
    private String handover;//'交付时间',

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

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSta() {
        return sta;
    }

    public void setSta(String sta) {
        this.sta = sta;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getPlaced() {
        return placed;
    }

    public void setPlaced(String placed) {
        this.placed = placed;
    }


    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String eliver) {
        this.deliver = eliver;
    }

    public String getHandover() {
        return handover;
    }

    public void setHandover(String handover) {
        this.handover = handover;
    }

    public Order(int rid, String user_id, String order_id, String sta,
                 int address_id, double payment, String placed,
                 String receipt, String deliver, String handover) {
        this.rid = rid;
        this.user_id = user_id;
        this.order_id = order_id;
        this.sta = sta;
        this.address_id = address_id;
        this.payment = payment;
        this.placed = placed;
        this.receipt = receipt;
        this.deliver = deliver;
        this.handover = handover;
    }

    public Order() {

    }

    @Override
    public String toString() {
        return "Order{" +
                "rid=" + rid +
                ", user_id='" + user_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", sta='" + sta + '\'' +
                ", address_id=" + address_id +
                ", payment=" + payment +
                ", placed=" + placed +
                ", receipt=" + receipt +
                ", deliver=" + deliver +
                ", handover=" + handover +
                '}';
    }
}
