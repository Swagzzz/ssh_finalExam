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

import java.util.List;
@Repository
public class UserDAO extends BaseDAO implements IUserDAO {
    @Override
    public boolean checkUser(User user) {
        //返回的类型是List<?> ，强制转换成一致的类型
        boolean flag = false;
        List<User> list = (List<User>) getHibernateTemplate().find("from t_user where id = ? and pwd = ?");
        if (list.size() > 0 )
            flag = true;
        else
            flag = false;
        return flag;
    }

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
                    sql.append(" and u.userId =:sex ");
                }
                Query query = session.createQuery(sql.toString());
                if (user.getUserId() != -1) {
                    query.setString("userid", "'".concat("%").concat("" + user.getUserId()).concat("%").concat("'"));
                }
                if (StringUtil.isNotEmpty(user.getFullName())) {
                    query.setString("fullName", "'".concat("%").concat(user.getFullName()).concat("%").concat("'"));
                }
                if (user.getSex() != -1) {
                    query.setString("sex", "'".concat("%").concat("" + user.getSex()).concat("%").concat("'"));
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
                    sql.append(" and u.userId like :userid ");
                }
                if (StringUtil.isNotEmpty(user.getFullName())) {
                    sql.append(" and u.fullName like :fullName");
                }
                if (user.getSex() != -1) {
                    sql.append(" and u.userId =:sex ");
                }
                Query query = session.createQuery(sql.toString());
                if (user.getUserId() != -1) {
                    query.setString("userid", "'".concat("%").concat("" + user.getUserId()).concat("%").concat("'"));
                }
                if (StringUtil.isNotEmpty(user.getFullName())) {
                    query.setString("fullName", "'".concat("%").concat(user.getFullName()).concat("%").concat("'"));
                }
                if (user.getSex() != -1) {
                    query.setString("sex", "'".concat("%").concat("" + user.getSex()).concat("%").concat("'"));
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
        if(opversion==0){
            getHibernateTemplate().save(user);
        }else {
            getHibernateTemplate().merge(user);
        }
    }

}
