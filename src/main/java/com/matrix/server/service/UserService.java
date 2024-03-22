package com.matrix.server.service;

import com.matrix.server.model.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName UserService
 * @Author Create By matrix
 * @Date 2024/3/21 0021 22:25
 */
@Service
public interface UserService {
    public UserInfo queryUser(String account,String password);
}
