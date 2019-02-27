package com.example.server.service;

import com.example.server.entity.UserInfo;

import java.util.List;

public interface UserService {

    Integer saveUser(UserInfo userInfo);

    UserInfo getUserById(Integer userId);

    List<UserInfo> getUserList();
}
