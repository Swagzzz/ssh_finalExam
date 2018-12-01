package com.org.pss.entity;

import java.util.HashSet;
import java.util.Set;

public class GoodsType {
    private int id;
    private String typeName;
    private int Goods_Id;
    private Set<Goods> goodss = new HashSet<Goods>();

    public GoodsType(){

    }

    public GoodsType(int id, String typeName, int goods_Id, Set<Goods> goodss) {
        this.id = id;
        this.typeName = typeName;
        Goods_Id = goods_Id;
        this.goodss = goodss;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getGoods_Id() {
        return Goods_Id;
    }

    public void setGoods_Id(int goods_Id) {
        Goods_Id = goods_Id;
    }

    public Set<Goods> getGoodss() {
        return goodss;
    }

    public void setGoodss(Set<Goods> goodss) {
        this.goodss = goodss;
    }
}
