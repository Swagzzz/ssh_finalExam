package com.org.pss.entity;

public class Role {
    private int id;
    private String roleName;
    private int level;
    private String remark;
    private User user;

    public Role(){

    }

    public Role(int id, String roleName, int level, String remark, User user) {
        this.id = id;
        this.roleName = roleName;
        this.level = level;
        this.remark = remark;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
