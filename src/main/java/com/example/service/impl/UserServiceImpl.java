package com.example.service.impl;

import com.example.entity.UserInfo;
import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Integer saveUser(UserInfo userInfo) {
        return userDao.saveUser(userInfo);
    }

    @Override
    public UserInfo getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<UserInfo> getUserList() {
        return userDao.getUserList();
    }
}
