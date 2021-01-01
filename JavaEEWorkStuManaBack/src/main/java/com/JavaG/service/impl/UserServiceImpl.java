package com.JavaG.service.impl;


import com.JavaG.dao.UserDao;
import com.JavaG.domain.Student;
import com.JavaG.domain.User;

import com.JavaG.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//实现UserService
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User login(User user){
        return userDao.getUser(user);
    }

    //检测是否存在
    public boolean checkUserIsExist(int id) {
        User result = userDao.getUserById(id);
        if (result == null) {
            return false;
        }
        return true;
    }

    public User getUser(int id) {
        return userDao.getUserById(id);
    }


    public void updatePass(int id, String newPass) {
        userDao.updatePass(id, newPass);
    }

    //获得所有学生用户
    public ArrayList<Student> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public void enableUser(int id) {
        userDao.updateUserStatus(id,1);
    }
    @Override
    public void disableUser(int id) {
        userDao.updateUserStatus(id,0);
    }


}


