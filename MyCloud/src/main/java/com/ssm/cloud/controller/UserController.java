package com.ssm.cloud.controller;

import com.ssm.cloud.pojo.User;
import com.ssm.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("go{page}.html")
    public String goPage(@PathVariable String page) {
        return page;
    }


    @RequestMapping("check.html")
    @ResponseBody
    public Integer check(String username) {
        return userService.getCountUser(username);
    }

    @RequestMapping("register.html")
    public String register(User user, String repwd,Model model) {

        System.out.println(user.getUsername()+""+user.getPassword());
        if (!repwd.equals(user.getPassword())) {
            model.addAttribute("message", "两次密码输入不一致");
            return "register";
        }
        if (userService.getCountUser(user.getUsername()) > 0) {
            model.addAttribute("message", "用户名已经存在");
            return "register";
        }
       userService.addUser(user);
        model.addAttribute("message", "注册成功");
        return "login";
    }


    @RequestMapping("login.html")
    public String login(String username, String password, Model model, HttpSession session) {
        System.out.println(username+""+password);
        User user = userService.doLogin(username, password);
        if (user == null) {
            model.addAttribute("message", "用户名或密码不正确");
            return "login";
        }
        session.setAttribute("SESSION_USER",user);
        return "redirect:/dir/list.html";

    }


}
