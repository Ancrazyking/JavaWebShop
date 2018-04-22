package com.ancrazyking.dao;

import com.ancrazyking.bean.User;

/**
 * @author Ancrazyking
 * @date 2018/4/22 19:53
 **/
public interface UserDao
{
    //注册用户
    public int register(User user)throws Exception;

    //激活用户
    public void active(String activeCode)throws Exception;

    //检查用户名是否存在
    public Long checkUsername(String username)throws Exception;
}
