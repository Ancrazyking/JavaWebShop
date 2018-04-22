package com.ancrazyking.test;

import com.ancrazyking.bean.User;
import com.ancrazyking.dao.UserDao;
import com.ancrazyking.dao.impl.UserDaoimpl;

/**
 * @author Ancrazyking
 * @date 2018/4/22 20:07
 **/
public class UserDaoTest
{
    public static void main(String[] args) throws Exception{
        UserDao userDao=new UserDaoimpl();
        User user=new User();
        user.setName("wangafeng");
        user.setPassword("123");
        user.setUid("11");
        userDao.register(user);

    }

}
