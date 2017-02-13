package com.ssm.web;


import com.alibaba.fastjson.JSONObject;
import com.avos.avoscloud.AVOSCloud;
import com.ssm.boot.AVOSCloudMain;
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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl service;


    @RequestMapping(value = "/helpme")
    public String helpme() {
        User user = service.findUserByEmail("terrence.tan@vgcs.me");
        System.out.println(user.getUsername() + "," + user.getEmail());
        return "/helpme";
    }

    //@CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getUserByEmail")
    public User getUser(@RequestParam String email) {
        System.err.println("传的参数是:" + "" + email);
        return service.findUserByEmail(email);
    }

    @CrossOrigin(origins = "http://localhost:63343")
    @ResponseBody
    @RequestMapping(value = "/getUserByName")
    public User getUserByCName(@RequestParam String cname) {
        return service.findUserByName(cname);
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
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password, @RequestParam String code,
                                     HttpServletRequest request, HttpServletResponse response) {
        String clientIp = getIpAddress(request);
        System.err.println("登录IP:" + clientIp);
        return null;
    }

    /**
     * 获取验证码
     *
     * @return code:1234
     */
    @ResponseBody
    @RequestMapping(value = "/getCode")
    public Map<String, Object> getCode() {
        Map<String, Object> map = new HashedMap();
        map.put("code", 1234);
        //AVOSCloudMain.initCloud();
        return map;
    }


    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }


}
