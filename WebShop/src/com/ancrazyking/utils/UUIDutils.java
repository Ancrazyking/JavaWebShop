package com.ancrazyking.utils;

import java.util.UUID;

/**
 * @author Ancrazyking
 * @date 2018/4/22 18:57
    用于生成32位16进制随机数字(128bit)
 **/
public class UUIDutils
{
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
    public static void main(String[] args){
       System.out.println(getUUID());
    }

}
