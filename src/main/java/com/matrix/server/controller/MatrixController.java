package com.matrix.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName MatrixController
 * @Author Create By matrix
 * @Date 2024/3/21 0021 1:50
 */

/**
 * 视图层逻辑
 */
@Controller
public class MatrixController {
    @RequestMapping("/index")
    public String Index(Model model, HttpSession session){
        if(session.getAttribute("login_user")!=null){
            model.addAttribute("login_user",session.getAttribute("login_user"));
            return "index";
        }
        return "index";
    }
    @RequestMapping("/login")
    public String Login(Model model,HttpSession session){
        model.addAttribute("message","欢迎");
        return "login";
    }
}
