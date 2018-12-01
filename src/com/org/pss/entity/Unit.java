package com.org.pss.entity;

public class Unit {
    private String uid;
    private String uName;
    private Goods goods;


    public Unit(){

    }

    public Unit(String uid, String uName, Goods goods) {
        this.uid = uid;
        this.uName = uName;
        this.goods = goods;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
