package com.org.pss.entity;

import java.util.HashSet;
import java.util.Set;

public class Secondfunc {
    private int id;
    private String firstGrade;
    private String funcName;
    private String funcNo;
    private Func func;
    private Set<User> userSet = new HashSet<User>();

    public Secondfunc(){

    }

    public Secondfunc(int id, String firstGrade, String funcName, String funcNo, Func func, Set<User> userSet) {
        this.id = id;
        this.firstGrade = firstGrade;
        this.funcName = funcName;
        this.funcNo = funcNo;
        this.func = func;
        this.userSet = userSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstGrade() {
        return firstGrade;
    }

    public void setFirstGrade(String firstGrade) {
        this.firstGrade = firstGrade;
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

    public Func getFunc() {
        return func;
    }

    public void setFunc(Func func) {
        this.func = func;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
