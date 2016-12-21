package com.ssm.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.User;
import com.ssm.service.impl.UserServiceImpl;
import com.ssm.turing.TuringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @RequestMapping(value = "/helpme")
    public String helpme() {
        User user = service.findUserByEmail("andy.lu@vgcs.me");
        System.out.println(user.getcName() + "," + user.getEmail());
        return "helpme";
    }

    @ResponseBody
    @RequestMapping(value = "/getUser")
    public User getUser(@RequestParam String email) {
        System.err.println("传的参数是:" + "" + email);
        return service.findUserByEmail(email);
    }


    @ResponseBody
    @RequestMapping(value = "/getUserByCName")
    public User getUserByCName(@RequestParam String cname) {
        return service.findUserByCName(cname);
    }

    @ResponseBody
    @RequestMapping(value = "/callRotot")
    public JSONObject callRotot(@RequestParam String cmd) {
        return TuringUtil.AskRobot(cmd);
    }
}
