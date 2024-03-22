package com.matrix.server.model.mapper;

/**
 * @ClassName UserMapper
 * @Author Create By matrix
 * @Date 2024/3/21 0021 22:24
 */

import com.matrix.server.model.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Mapper接口
 */
@Mapper //mybatis的mapper类
@Repository //将mapper交由spring容器管理
public interface UserMapper {

    public UserInfo queryUserInfo(Map<String,Object> map);

    @Select("select " +
            "uId," +
            "uHead," +
            "uName," +
            "uPassword," +
            "uSex," +
            "uAccount," +
            "uPhone," +
            "uEmail," +
            "uLevel," +
            "uStatus," +
            "uAddressIp " +
            "from user_info_data " +
            "where uAccount=#{account} " +
            "and uPassword=#{password}")
    public UserInfo queryUser(@Param("account") String account,@Param("password") String password);//登录
}
