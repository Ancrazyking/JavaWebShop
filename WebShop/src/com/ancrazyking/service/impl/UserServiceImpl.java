package com.ancrazyking.service.impl;

import com.ancrazyking.bean.User;
import com.ancrazyking.dao.UserDao;
import com.ancrazyking.dao.impl.UserDaoimpl;
import com.ancrazyking.service.UserService;

import java.sql.SQLException;

/**
 * @author Ancrazyking
 * @date 2018/4/22 20:34
 **/
public class UserServiceImpl implements UserService
{
    private UserDao userDao=new UserDaoimpl();
    @Override
    public boolean register(User user)
    {
        int row=0;
        try{
            row=userDao.register(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row>0?true:false;
    }



    @Override
    public void active(String activeCode)
    {
        try{
            userDao.active(activeCode);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean checkUsername(String username)
    {
        Long isExist=0L;
        try{
            isExist=userDao.checkUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isExist>0?true:false;
    }
}
