package com.ssm.test;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findAllUserByEmail() throws Exception {
        User user = userDao.findUserByEmail("andy.lu@vgcs.me");

        System.out.println(user.getUsername() + "," + user.getUsername());
    }
}
