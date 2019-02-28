package com.example.dao;

import com.example.entity.UserInfo;

import java.util.List;

public interface UserDao {

    Integer saveUser(UserInfo userInfo);

    UserInfo getUserById(Integer userId);

    List<UserInfo> getUserList();
}
