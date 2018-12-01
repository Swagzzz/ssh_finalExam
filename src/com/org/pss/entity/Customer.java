package com.org.pss.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    //定义的私有属性
    private int cId;//客户编号
    private String cusName;//客户名称
    private String cusType;//客户类型
    private Double origPay;//初始应付
    private Double Arrears;//应付欠款
    private String perContact;//联系人
    private int mpTel;//手机号码
    private String salesMan;//业务员
    private Date greatedate;//创建时间
    private Set<Order> orders = new HashSet<Order>();//订单集合，客户-订单：一对多关系
    private Set<Goods> goodss =new HashSet<Goods>();//货品集合
    private Set<Customer> customers;
    private Set<Supplier> suppliers;


    //无参构造函数
    public Customer(){

    }

    //有参构造函数


    public Customer(int cId, String cusName, String cusType, Double origPay, Double arrears, String perContact, int mpTel, String salesMan, Date greatedate, Set<Order> orders, Set<Goods> goodss, Set<Customer> customers, Set<Supplier> suppliers) {
        this.cId = cId;
        this.cusName = cusName;
        this.cusType = cusType;
        this.origPay = origPay;
        Arrears = arrears;
        this.perContact = perContact;
        this.mpTel = mpTel;
        this.salesMan = salesMan;
        this.greatedate = greatedate;
        this.orders = orders;
        this.goodss = goodss;
        this.customers = customers;
        this.suppliers = suppliers;
    }



    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    public Double getOrigPay() {
        return origPay;
    }

    public void setOrigPay(Double origPay) {
        this.origPay = origPay;
    }

    public Double getArrears() {
        return Arrears;
    }

    public void setArrears(Double arrears) {
        Arrears = arrears;
    }

    public String getPerContact() {
        return perContact;
    }

    public void setPerContact(String perContact) {
        this.perContact = perContact;
    }

    public int getMpTel() {
        return mpTel;
    }

    public void setMpTel(int mpTel) {
        this.mpTel = mpTel;
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public Date getGreatedate() {
        return greatedate;
    }

    public void setGreatedate(Date greatedate) {
        this.greatedate = greatedate;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Goods> getGoodss() {
        return goodss;
    }

    public void setGoodss(Set<Goods> goodss) {
        this.goodss = goodss;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}

