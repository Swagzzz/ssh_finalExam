package com.org.pss.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
    private  int userId;
    private String pwd;
    private String fullName;
    private int sex;
   // private String oid;
    private String mpTel;
    private String Address;
   // private int roleId;
    private int isAlived;
    private String Email;
    private Set<Secondfunc> secondfuncs = new HashSet<Secondfunc>();
    private Set<Order> orders = new HashSet<Order>();
    private Set<Role> roles = new HashSet<Role>();

    public User(int userId, String fullName, int sex) {
        this.userId = userId;
        this.fullName = fullName;
        this.sex = sex;
    }

    public User(int userId, String pwd, String fullName, int sex, String mpTel, String address, int isAlived, String email, Set<Secondfunc> secondfuncs, Set<Order> orders, Set<Role> roles) {
        this.userId = userId;
        this.pwd = pwd;
        this.fullName = fullName;
        this.sex = sex;
        this.mpTel = mpTel;
        Address = address;
        this.isAlived = isAlived;
        Email = email;
        this.secondfuncs = secondfuncs;
        this.orders = orders;
        this.roles = roles;
    }

    public User() {
    }

    public User(int userId, int sex) {
        this.userId = userId;
        this.sex = sex;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMpTel() {
        return mpTel;
    }

    public void setMpTel(String mpTel) {
        this.mpTel = mpTel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getIsAlived() {
        return isAlived;
    }

    public void setIsAlived(int isAlived) {
        this.isAlived = isAlived;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Set<Secondfunc> getSecondfuncs() {
        return secondfuncs;
    }

    public void setSecondfuncs(Set<Secondfunc> secondfuncs) {
        this.secondfuncs = secondfuncs;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
