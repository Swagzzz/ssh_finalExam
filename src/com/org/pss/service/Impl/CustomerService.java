package com.org.pss.service.Impl;

import com.org.pss.dao.ICustomerDAO;
import com.org.pss.entity.Customer;
import com.org.pss.entity.Page;
import com.org.pss.service.ICustomerService;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Resource
    private ICustomerDAO customerDAO;

    @Override
    public List<Customer> findAllInfo(Page page, Customer customer) {
        List<Customer> list = customerDAO.findAllInfo(page, customer);
        return list;
    }

    @Override
    public int countInfo(Page page, Customer customer) {
        int i = customerDAO.countInfo(page, customer);
        return i;
    }

    @Override
    public int saveCustomer(Customer customer) {
        int flag = 0;
        try {
            customerDAO.saveCustomer(customer);
            flag = 1;
        } catch (HibernateException e) {
            flag = 0;
            e.printStackTrace();
        }
        return flag;
    }

    public int[] delCustomer(String ids) {
        int seccFlag = 0;
        int failFlag = 0;
        try {
            int arr[] = customerDAO.delCustomer(ids);
            if (arr[0] > 0) {
                seccFlag = 1;
                failFlag = 1;
            } else {
                seccFlag = 0;
                failFlag = arr[1];
            }
        } catch (HibernateException e) {
            seccFlag = 0;
            failFlag = 0;
            e.printStackTrace();
        }
        int arr[] = {seccFlag,failFlag};

        return arr;
    }

    @Override
    public String findCustomerById(int id) {
        return customerDAO.findCustomerById(id);
    }

    @Override
    public int findCustomerByName(String cusName) {
        int flag = customerDAO.findCustomerByName(cusName);
        return flag;
    }

}