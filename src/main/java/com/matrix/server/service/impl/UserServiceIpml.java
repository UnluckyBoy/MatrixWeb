package com.matrix.server.service.impl;

import com.matrix.server.model.mapper.UserMapper;
import com.matrix.server.model.pojo.UserInfo;
import com.matrix.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName UserServiceIpml
 * @Author Create By matrix
 * @Date 2024/3/21 0021 22:27
 */
@Service("UserService")
public class UserServiceIpml implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo queryUser(String account, String password) {
        return userMapper.queryUser(account,password);
    }
}
