package com.org.pss.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Supplier {
    private int sid;
    private String spName;
    private Double origPay;
    private Double Arrears;
    private String perContact;
    private String mpTel;
    private Date greateDate;
    private String Adress;
    private String remark;
    private String Code;
    private Set<Goods> goodss =new HashSet<Goods>();//货品集合
    private Set<Order> orders =new HashSet<Order>();

    public Supplier(){

    }

    public Supplier(int sid, String spName, Double origPay, Double arrears, String perContact, String mpTel, Date greateDate, String adress, String remark, String code, Set<Goods> goodss, Set<Order> orders) {
        this.sid = sid;
        this.spName = spName;
        this.origPay = origPay;
        Arrears = arrears;
        this.perContact = perContact;
        this.mpTel = mpTel;
        this.greateDate = greateDate;
        Adress = adress;
        this.remark = remark;
        Code = code;
        this.goodss = goodss;
        this.orders = orders;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
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

    public String getMpTel() {
        return mpTel;
    }

    public void setMpTel(String mpTel) {
        this.mpTel = mpTel;
    }

    public Date getGreateDate() {
        return greateDate;
    }

    public void setGreateDate(Date greateDate) {
        this.greateDate = greateDate;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Set<Goods> getGoodss() {
        return goodss;
    }

    public void setGoodss(Set<Goods> goodss) {
        this.goodss = goodss;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
