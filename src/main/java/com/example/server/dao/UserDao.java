package com.example.server.dao;

import com.example.server.entity.UserInfo;

import java.util.List;

public interface UserDao {

    Integer saveUser(UserInfo userInfo);

    UserInfo getUserById(Integer userId);

    List<UserInfo> getUserList();
}
