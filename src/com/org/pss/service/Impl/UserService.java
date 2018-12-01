package com.org.pss.service.Impl;

import com.org.pss.dao.IUserDAO;
import com.org.pss.entity.Page;
import com.org.pss.entity.User;
import com.org.pss.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    @Qualifier("userDAO")
    private IUserDAO userDAO;
    @Override
    public boolean checkUser(User user) {
        boolean flag = false;
        try {
            flag = userDAO.checkUser(user);
        }catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public List<User> listUser(User user, Page page) {
        List<User> listuser = null;
        try{
            listuser=userDAO.listUser(user,page);
        }catch (Exception e){
            e.printStackTrace();
            listuser = null;
        }
        return listuser;
    }

    @Override
    public int countUser(User user, Page page) {
        int result = 0;
        try {
            result = userDAO.countUser(user, page);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public int delUser(int id) {
        int result = 0;
        try {
            userDAO.delUser(id);
            result = 1;
        }catch (Exception e) {
            result = 0;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public int userInfoOp(User user, int opversion) {
        int result = 0;
        try {
            userDAO.userInfoOp(user,opversion);
            result = 1;
        }catch (Exception e) {
            result = 0;
            e.printStackTrace();
        }
        return result;
    }
}
