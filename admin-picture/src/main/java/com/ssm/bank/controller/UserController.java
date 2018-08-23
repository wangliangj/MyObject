package com.ssm.bank.controller;

import com.ssm.bank.pojo.User;
import com.ssm.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("go{page}.html")
    public String goPage(@PathVariable String page) {
        return page;
    }

    @RequestMapping("login.html")
    @ResponseBody
    public Map<String, String> login(String cardId, String password, HttpSession session) {
        HashMap<String, String> result = new HashMap<>();
        if (StringUtils.isEmpty(cardId) || cardId.length() != 16) {
            result.put("error", "请填写16位卡号");
            return result;
        }
        if (StringUtils.isEmpty(password) || password.length() != 6) {
            result.put("error", "请填写6位密码");
        }
        User user = userService.doLogin(cardId, password);
        if (user==null) {
            result.put("error", "卡号或密码不正确");
            return result;
        }
        session.setAttribute("SESSION_USER", user);
        result.put("message", "登录成功");
        return result;
    }

    @RequestMapping("logout.html")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping("changepwd.html")
    @ResponseBody
    public Map<String ,String> changPassword(String pwd, String npwd, String repwd,HttpSession session) {
        Map<String, String> result = new HashMap<>();
        if (StringUtils.isEmpty(pwd) || StringUtils.isEmpty(npwd) || StringUtils.isEmpty(repwd)) {
            result.put("error", "请填写完整表单");
            return result;
        }
        if (!npwd.equals(repwd)) {
            result.put("error", "两次密码输入不一致");
        }
        User user = (User) session.getAttribute("SESSION_USER");
        String oldpassword = userService.getPasswordById(user.getId());
        if (!pwd.equals(oldpassword)) {
            result.put("error", "旧密码输入不正确");
            return result;
        }
        user.setPassword(npwd);
        userService.updateUser(user);
        result.put("message", "修改成功");
        return result;

    }

    @RequestMapping("trade.html")
    @ResponseBody
    public Map<String, String> trade(Float amount, String card, HttpSession session) {
        User user = (User) session.getAttribute("SESSION_USER");
        Map<String, String> result = new HashMap<>();
        try {
            userService.doTrade(user.getId(), amount, card);
            result.put("message", "成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("error", e.getMessage());
        }
        return result;
    }
}
