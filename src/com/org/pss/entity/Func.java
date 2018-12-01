package com.org.pss.entity;

import java.util.HashSet;
import java.util.Set;

public class Func {
    private int id;
    private String funcName;
    private String funcNo;
    private Set<Secondfunc> secondfuncs = new HashSet<Secondfunc>();

    public Func(){

    }

    public Func(int id, String funcName, String funcNo, Set<Secondfunc> secondfuncs) {
        this.id = id;
        this.funcName = funcName;
        this.funcNo = funcNo;
        this.secondfuncs = secondfuncs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncNo() {
        return funcNo;
    }

    public void setFuncNo(String funcNo) {
        this.funcNo = funcNo;
    }

    public Set<Secondfunc> getSecondfuncs() {
        return secondfuncs;
    }

    public void setSecondfuncs(Set<Secondfunc> secondfuncs) {
        this.secondfuncs = secondfuncs;
    }
}
