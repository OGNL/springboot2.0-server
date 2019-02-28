package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer saveUser(UserInfo userInfo) {
        StringBuilder sql = new StringBuilder(" INSERT INTO T_UserInfo(UserName, Phone, Password, Address) ")
                .append(" VALUES(?, ?, ?, ?)");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(ps ->{
            PreparedStatement preparedStatement = ps.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1,userInfo.getUserName());
            preparedStatement.setObject(2,userInfo.getPhone());
            preparedStatement.setObject(3,userInfo.getPassword());
            preparedStatement.setObject(4,userInfo.getAddress());
            return preparedStatement;
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public UserInfo getUserById(Integer userId) {
        StringBuilder sql = new StringBuilder(" SELECT UserId, UserName, Phone, Password, Address FROM T_UserInfo  ")
                .append(" WHERE UserId = ? ");
        return jdbcTemplate.queryForObject(sql.toString(),new Object[]{userId},new BeanPropertyRowMapper<>(UserInfo.class));
    }

    @Override
    public List<UserInfo> getUserList() {
        StringBuilder sql = new StringBuilder(" SELECT UserId, UserName, Phone, Password, Address FROM T_UserInfo ");
        return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(UserInfo.class));
    }
}
