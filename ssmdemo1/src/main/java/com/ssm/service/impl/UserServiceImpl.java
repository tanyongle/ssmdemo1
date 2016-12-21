package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;


    public User findUserByEmail(String s) {
        return userDao.findUserByEmail(s);
    }

    public User findUserByCName(String c) {
        return userDao.findUserByCName(c);
    }
}
