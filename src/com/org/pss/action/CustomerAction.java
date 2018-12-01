package com.org.pss.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.pss.entity.Customer;
import com.org.pss.entity.Page;
import com.org.pss.service.ICustomerService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller("customerAction")
@Scope("prototype")
public class CustomerAction extends ActionSupport {
    private JSONObject jsonObject;//异步请求，也就是ajax请求
    private int cId;//可以根据这个用户id去获取数据表中的用户所有属性
    private int page;//表示从第几页开始
    private int limit;//表示一页限制多少条数据
    @Autowired
    private ICustomerService customerService;
    private Customer customer;
    private String cusName,cusType,perContact,salesMan;
    private double origPay,Arrears;
    private int mpTel;
    private Date greatedate;
    public String getCustomers () {
        List<Customer> list = customerService.findAllInfo(new Page(page, limit), null);

        return "SUCCESS";
    }
    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public String getPerContact() {
        return perContact;
    }

    public void setPerContact(String perContact) {
        this.perContact = perContact;
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public double getOrigPay() {
        return origPay;
    }

    public void setOrigPay(double origPay) {
        this.origPay = origPay;
    }

    public double getArrears() {
        return Arrears;
    }

    public void setArrears(double arrears) {
        Arrears = arrears;
    }

    public int getMpTel() {
        return mpTel;
    }

    public void setMpTel(int mpTel) {
        this.mpTel = mpTel;
    }

    public Date getGreatedate() {
        return greatedate;
    }

    public void setGreatedate(Date greatedate) {
        this.greatedate = greatedate;
    }

}
