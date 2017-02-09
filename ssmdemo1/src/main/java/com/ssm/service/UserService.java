package com.ssm.service;


import com.ssm.entity.User;

public interface UserService {
    User findUserByEmail(String s);

    User findUserByName(String s);
}
