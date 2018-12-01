package com.org.pss.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Goods implements Serializable{
    private static final long serialVersionUID = 1L;
    //定义的私有属性
    private int id;//货品id
    private String goodsImg;//货品图片
    private String goodsName;//货品名称
    private int goodsType;//货品类型
    private String goodsNo;//货品编号
    private Double buyPrice;//采购价
    private Double retPrice;//零售价
    private int sid;//供应商id
    private int store;//库存
    private Double baoPrice;//报价
    private int uid;//单位id
    private int oid;//订单号id
    private Set<Customer> customers = new HashSet<Customer>();
    private Set<Supplier> suppliers =new HashSet<Supplier>();//货品集合
    private Set<GoodsType> goodsTypes = new HashSet<GoodsType>();
    private Set<Unit> units = new HashSet<Unit>();


    public Goods(){

    }

    public Goods(int id, String goodsImg, String goodsName, int goodsType, String goodsNo, Double buyPrice, Double retPrice, int sid, int store, Double baoPrice, int uid, int oid, Set<Customer> customers, Set<Supplier> suppliers, Set<GoodsType> goodsTypes, Set<Unit> units) {
        this.id = id;
        this.goodsImg = goodsImg;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsNo = goodsNo;
        this.buyPrice = buyPrice;
        this.retPrice = retPrice;
        this.sid = sid;
        this.store = store;
        this.baoPrice = baoPrice;
        this.uid = uid;
        this.oid = oid;
        this.customers = customers;
        this.suppliers = suppliers;
        this.goodsTypes = goodsTypes;
        this.units = units;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getRetPrice() {
        return retPrice;
    }

    public void setRetPrice(Double retPrice) {
        this.retPrice = retPrice;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public Double getBaoPrice() {
        return baoPrice;
    }

    public void setBaoPrice(Double baoPrice) {
        this.baoPrice = baoPrice;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    public Set<GoodsType> getGoodsTypes() {
        return goodsTypes;
    }

    public void setGoodsTypes(Set<GoodsType> goodsTypes) {
        this.goodsTypes = goodsTypes;
    }

    public Set<Unit> getUnits() {
        return units;
    }

    public void setUnits(Set<Unit> units) {
        this.units = units;
    }
}
