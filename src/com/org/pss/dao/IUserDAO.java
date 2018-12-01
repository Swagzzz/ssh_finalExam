package com.org.pss.dao;

import com.org.pss.entity.Page;
import com.org.pss.entity.User;

import java.util.List;

public interface IUserDAO {
    boolean checkUser (User user);
    List<User> listUser (User user, Page page);
    int countUser (User user, Page page);
    void delUser (int id);
    void userInfoOp(User user,int opversion);
}
