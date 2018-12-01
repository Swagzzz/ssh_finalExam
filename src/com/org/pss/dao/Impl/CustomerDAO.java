package com.org.pss.dao.Impl;

import com.org.pss.dao.BaseDAO;
import com.org.pss.dao.ICustomerDAO;
import com.org.pss.entity.Customer;
import com.org.pss.entity.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import util.StringUtil;

import java.util.List;

@Repository
public class CustomerDAO extends BaseDAO implements ICustomerDAO {
    @Override
    public List<Customer> findAllInfo(Page page, Customer customer) {
        List<Customer> list = (List<Customer>) getHibernateTemplate().execute(
                new HibernateCallback<Object>() {
                    public Object doInHibernate(Session session) {
                        StringBuffer hql = new StringBuffer(" from t_customer e where 1=1 ");
                        Query query = null;
                        if (customer == null) {
                            query = session.createQuery(hql.toString());
                            return query.list();
                        }
                        if (customer.getcId() != 0) {
                            hql.append(" and e.cId like :id");
                        }
                        if (StringUtil.isNotEmpty(customer.getCusName())) {
                            hql.append(" and e.cusName like :name");
                        }
                        query = session.createQuery(hql.toString());
                        if (customer.getcId() != 0) {
                            query.setString("id", "%" + customer.getcId() + "%");
                        }
                        if (StringUtil.isNotEmpty(customer.getCusName())) {
                            query.setString("name", "%" + customer.getCusName() + "%");
                        }
                        query.setFirstResult(page.getStart());
                        query.setMaxResults(page.getLimit());
                        return query.list();
                    }
                }
        );
        return list;
    }

    @Override
    public int countInfo(Page page, Customer customer) {
        return 0;
    }

    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public int[] delCustomer(String ids) {
        return new int[0];
    }

    @Override
    public String findCustomerById(int id) {
        return null;
    }

    @Override
    public int findCustomerByName(String cusName) {
        return 0;
    }
}
