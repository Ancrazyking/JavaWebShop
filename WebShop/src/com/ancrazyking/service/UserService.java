package com.ancrazyking.service;

import com.ancrazyking.bean.User;

/**
 * @author Ancrazyking
 * @date 2018/4/22 20:32
 **/
public interface UserService
{
     boolean register(User user);


     void active(String activeCode);


     boolean checkUsername(String username);

}
