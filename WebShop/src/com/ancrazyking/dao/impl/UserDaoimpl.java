package com.ancrazyking.dao.impl;

import com.ancrazyking.bean.User;
import com.ancrazyking.dao.UserDao;
import com.ancrazyking.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * @author Ancrazyking
 * @date 2018/4/22 19:56
 **/
public class UserDaoimpl implements UserDao
{
    @Override//又是哪门子sql语句
    public int register(User user) throws Exception
    {
        QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        int update = queryRunner.update(sql, user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),
                user.getSex(),user.getState(),user.getCode());
        return update;
    }

    @Override
    public void active(String activeCode) throws Exception
    {
        QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
        String sql="update user set state=? where code=?";
        queryRunner.update(sql,1,activeCode);
    }

    @Override
    public Long checkUsername(String username) throws Exception
    {
        QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
        String sql="select count(*) from user where username=?";
        Long query=(Long) queryRunner.query(sql,new ScalarHandler(),username);
        return query;
    }
}
