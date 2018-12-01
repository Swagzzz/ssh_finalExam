package com.org.pss.entity;

import java.util.Date;

public class Order {
    private int oId;//订单编号
    private Date orderTime;//订单时间
    private int State;//状态，0:已下单，1：不接单,3:已出货，2：已进货
    private double Price;//订单价格
    private int Total;//订单总数
   // private int cId;//客户id
    //private int sId;//供应商id
    private int isApprove;//是否审批通过，0:审批通过 1：待审批 2：审批不通过
    private Customer customer;
    private User user;
    private Supplier supplier;

    //无参构造函数
    public Order(){

    }

    //有参构造函数


    public Order(int oId, Date orderTime, int state, double price, int total/*, int cId*//*, int sId*/, int isApprove, Customer customer, User user, Supplier supplier) {
        this.oId = oId;
        this.orderTime = orderTime;
        State = state;
        Price = price;
        Total = total;
       // this.cId = cId;
        //this.sId = sId;
        this.isApprove = isApprove;
        this.customer = customer;
        this.user = user;
        this.supplier = supplier;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    /*public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }*/

    /*public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }*/

    public int getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(int isApprove) {
        this.isApprove = isApprove;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
