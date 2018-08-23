package com.ssm.users.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.users.pojo.User;
import com.ssm.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public Map<String, String> login(String username, String password, HttpSession session) {
        Map<String, String> result = new HashMap<>();

        Integer count = userService.getCountByUserName(username);
        if (count == 0) {
            result.put("error", "登录失败，用户名不存在");
            return result;
        }

        User user = userService.doLogin(username, password);
        if (user == null) {

            result.put("error", "登录失败，用户名和密码错误");
            return result;

        }

        Integer status = userService.getUserStatus(user.getId());
        if (status == 1) {
            result.put("error", "登录失败，该用户已冻结");
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

    @RequestMapping("logs.html")
    public ModelAndView logs(String username, @RequestParam(defaultValue = "1") Integer pn, HttpSession session) {
        User user = (User) session.getAttribute("SESSION_USER");
        Map<String, Object> param = new HashMap<>();

        param.put("username", username);
        PageInfo<User> pageInfo = userService.getUserList(param, pn, 5);
        return new ModelAndView("logs", "pageInfo", pageInfo);

    }

    @RequestMapping("changepwd.html")
    @ResponseBody
    public Map<String, String> changePwd(String pwd,String npwd,String repwd,HttpSession session) {
        Map<String, String> result = new HashMap<>();

        if (StringUtils.isEmpty(pwd) || StringUtils.isEmpty(npwd) || StringUtils.isEmpty(repwd)) {
            result.put("error", "请填写完整表单");
            return result;
        }

        if (!npwd.equals(repwd)) {
            result.put("error", "两次密码填写不一致");
            return result;
        }
        User user = (User) session.getAttribute("SESSION_USER");

        String password = userService.getPasswordById(user.getId());
        if (!pwd.equals(password)) {
            result.put("error", "旧密码输入不正确");
            return result;
        }
        user.setPassword(npwd);
        userService.updateUser(user);
        result.put("message", "修改成功");
        return result;
    }





}
