package com.example.server.service.impl;

import com.example.server.dao.UserDao;
import com.example.server.entity.UserInfo;
import com.example.server.service.UserService;
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
