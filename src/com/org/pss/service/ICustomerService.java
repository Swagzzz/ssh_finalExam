package com.org.pss.service;

import com.org.pss.entity.Customer;
import com.org.pss.entity.Page;


import java.util.List;

public interface ICustomerService {
    public List<Customer> findAllInfo(Page page, Customer customer) ;

    public int countInfo(Page page,Customer customer);

    public int  saveCustomer(Customer customer);

    public int[]delCustomer(String ids);

    public String findCustomerById(int id);

    public int findCustomerByName(String cusName);
}
