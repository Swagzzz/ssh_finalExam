package com.org.pss.dao;

import com.org.pss.entity.Customer;
import com.org.pss.entity.Page;

import java.util.List;

public interface ICustomerDAO {
    public List<Customer> findAllInfo(Page page, Customer customer);

    public int countInfo(Page page,Customer customer);

    public void saveCustomer(Customer customer);

    public int[]delCustomer(String ids);

    public String findCustomerById(int id);

    public int findCustomerByName(String cusName);

}
