package com.matrix.server.controller;

import com.matrix.server.model.pojo.UserInfo;
import com.matrix.server.service.UserService;
import com.matrix.server.tools.Pwd3DESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserInfoController
 * @Author Create By matrix
 * @Date 2024/3/21 0021 22:11
 */

/**
 * 用户信息层逻辑
 */
@Controller
@RequestMapping("/UserInfo")
public class UserInfoController {
    private static final String PASSWORD_EncyKEY = "EncryptionKey_By-WuMing";//自定义密钥
    private static String system_Path=System.getProperty("user.dir")+"/BackResource/";
    private static String mHand="default.png";//默认头像地址
    private static String product_dir="ProductIcon/";//产品图片路径
    private static String user_dir="HeadIcon/";//用户图片路径

    @Autowired
    private UserService userService;

    /**
     * 登录逻辑
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/handleLogin")
    public ResponseEntity<String> handleLogin(Model model, HttpSession session,
                                              @RequestParam("account") String account,
                                              @RequestParam("password") String password){
        System.out.println("请求内容:"+account+","+password);
        //Map<String,Object> loginMap=new HashMap<>();
        //loginMap.put("account",account);
        //loginMap.put("password", Pwd3DESUtil.encode3Des(PASSWORD_EncyKEY,password));
        //UserInfo userInfo=userService.queryUserInfo(loginMap);
        UserInfo userInfo=userService.queryUser(account,Pwd3DESUtil.encode3Des(PASSWORD_EncyKEY,password));
        System.out.println("请求结果:"+userInfo);
        if(userInfo==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failed");
        }
        session.setAttribute("login_user",userInfo);
        return ResponseEntity.ok("success");
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed");
    }
}
