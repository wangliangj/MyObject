package com.ssm.bank.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.bank.pojo.Trade;
import com.ssm.bank.pojo.User;
import com.ssm.bank.service.TradeService;
import com.ssm.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @RequestMapping("/logs.html")
    public ModelAndView logs(String startDate, String endDate, @RequestParam(defaultValue = "1")Integer pn, HttpSession session) {
        User user = (User) session.getAttribute("SESSION_USER");
        Map<String, Object> param = new HashMap<>();
        param.put("userId", user.getId());
        param.put("startDate", startDate);
        param.put("endDate", endDate);
        PageInfo<Trade> pageInfo = tradeService.getTradeList(param, pn, 3);
        return new ModelAndView("logs", "pageInfo", pageInfo);

    }



}
