package com.org.pss.dao.Impl;

import com.org.pss.dao.BaseDAO;
import com.org.pss.dao.IUserDAO;
import com.org.pss.entity.Page;
import com.org.pss.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import util.StringUtil;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDAO extends BaseDAO implements IUserDAO {

    @Override
    public List<User> listUser(User user, Page page) {
        List <User> list = (List<User>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                StringBuffer sql = new StringBuffer("from User u where 1=1 ");
                if (user.getUserId() != -1) {
                    sql.append(" and u.userId like :userid ");
                }
                if (StringUtil.isNotEmpty(user.getFullName())) {
                    sql.append(" and u.fullName like :fullName");
                }
                if (user.getSex() != -1) {
                    sql.append(" and u.sex =:sex ");
                }
                Query query = session.createQuery(sql.toString());
                if (user.getUserId() != -1) {
                    query.setString("userid", "%".concat("" + user.getUserId()).concat("%"));
                }
                if (StringUtil.isNotEmpty(user.getFullName())) {
                    query.setString("fullName", "%".concat(user.getFullName()).concat("%"));
                }
                if (user.getSex() != -1) {
                    query.setInteger("sex", user.getSex());
                }
                return query.list();
            }
        });
        return list;
    }

    @Override
    public int countUser(User user, Page page) {
        int result = (int) getHibernateTemplate().execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                StringBuffer sql = new StringBuffer("select count(*) from User u where 1=1 ");
                if (user.getUserId() != -1) {
                    sql.append(" and u.userId like :userId ");
                }
                if (StringUtil.isNotEmpty(user.getFullName())) {
                    sql.append(" and u.fullName like :fullName");
                }
                if (user.getSex() != -1) {
                    sql.append(" and u.sex =:sex ");
                }
                Query query = session.createQuery(sql.toString());
                if (user.getUserId() != -1) {
                    query.setString("userId", "%".concat("" + user.getUserId()).concat("%"));
                }
                if (StringUtil.isNotEmpty(user.getFullName())) {
                    query.setString("fullName", "%".concat(user.getFullName()).concat("%"));
                }
                if (user.getSex() != -1) {
                    query.setInteger("sex", user.getSex());
                }
                return Integer.parseInt(query.list().get(0).toString()); // 2 , "2", Integer.parseInt(arg) 2
            }
        });
        return result;
    }

    @Override
    public void delUser(int id) {
        getHibernateTemplate().delete(getHibernateTemplate().get(User.class, id));
    }

    @Override
    public void userInfoOp(User user, int opversion) { //规定opversion为0则为添加，否则1为修改
        if(opversion == 0){
            getHibernateTemplate().save(user);
        }else {
            getHibernateTemplate().update(user);
        }
    }

    @Override
    public void userRegister(User user)  {
        getHibernateTemplate().save(user);
    }

    @Override
    public boolean ValidateByNameOrID(User user) {
        List<User> list = null;
        if (user.getUserId() != 0)  //根据userAction的login方法，如果set的是userId那么说明user.getUserId就不会是0，然后根据id查
            list= (List<User>) getHibernateTemplate().find("from User where id = ? and pwd = ?", user.getUserId(), user.getPwd());
        else {
            list= (List<User>) getHibernateTemplate().find("from User where fullName = ? and pwd = ?",
                    user.getFullName(), user.getPwd());

        }
        if (list.size() > 0)
            return true;
        else
            return false;
    }


}
