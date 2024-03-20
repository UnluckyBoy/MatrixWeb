package com.matrix.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName MatrixController
 * @Author Create By matrix
 * @Date 2024/3/21 0021 1:50
 */
@Controller
public class MatrixController {
    @RequestMapping("/index")
    public String Index(Model model){
        model.addAttribute("message","欢迎");
        return "index";
    }
    @RequestMapping("/login")
    public String Login(Model model){
        model.addAttribute("message","欢迎");
        return "login";
    }
}
