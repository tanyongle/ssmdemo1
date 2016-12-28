package com.ssm.web;


import com.alibaba.fastjson.JSONObject;
import com.ssm.entity.User;
import com.ssm.service.impl.UserServiceImpl;
import com.ssm.turing.TuringUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl service;


    @RequestMapping(value = "/helpme")
    public String helpme() {
        User user = service.findUserByEmail("andy.lu@vgcs.me");
        System.out.println(user.getcName() + "," + user.getEmail());
        return "/helpme";
    }

    //@CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getUser")
    public User getUser(@RequestParam String email) {
        System.err.println("传的参数是:" + "" + email);
        return service.findUserByEmail(email);
    }

    @CrossOrigin(origins = "http://localhost:63343")
    @ResponseBody
    @RequestMapping(value = "/getUserByCName")
    public User getUserByCName(@RequestParam String cname) {
        return service.findUserByCName(cname);
    }

    @CrossOrigin(origins = "http://localhost:63343")
    @ResponseBody
    @RequestMapping(value = "/callRotot")
    public JSONObject callRobot(@RequestParam String cmd) {
        return TuringUtil.AskRobot(cmd);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/checkUser")
    public Map<String, Object> checkUser(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashedMap();
        System.out.println(request.getParameterMap());
        map.put("result", TuringUtil.AskRobot("你叫什么名字？"));
        return map;
    }


    /**
     * 登陆验证
     *
     * @param username
     * @param password
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password, @RequestParam String code) {
        return null;
    }

    /**
     * 获取验证码
     * @return code:1234
     */
    @ResponseBody
    @RequestMapping(value = "/getCode")
    public Map<String, Object> getCode() {
        Map<String, Object> map = new HashedMap();
        map.put("code", 1234);

        return map;
    }


}
