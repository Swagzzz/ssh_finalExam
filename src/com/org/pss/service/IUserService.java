package com.org.pss.service;

import com.org.pss.entity.Page;
import com.org.pss.entity.User;

import java.util.List;

public interface IUserService {
    //public boolean checkUser(User user);


    public List<User> listUser(User user, Page page);

    public int countUser(User user, Page page);

    int delUser (int id);

    int userInfoOp(User user,int opversion);


    public int save_userRegister(User user);

    //
    public boolean ValidateByNameOrID(User user);
}
