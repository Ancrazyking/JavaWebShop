package com.ancrazyking.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Ancrazyking
 * @date 2018/4/22 19:33
 * c3p0连接池
 **/
public class DBUtils
{
    private static DataSource dataSource = new ComboPooledDataSource();

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    //直接可以获取一个连接池
    public static DataSource getDataSource()
    {
        return dataSource;
    }

    //获取连接对象
    public static Connection getConnection() throws SQLException
    {
        Connection connection = threadLocal.get();
        if (connection == null)
        {
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }

    //开启事务
    public static void startTransaction() throws SQLException
    {
        Connection connection = getConnection();
        if (connection != null)
        {
            connection.setAutoCommit(false);
        }


    }


    //事务回滚
    public static void rollback() throws SQLException
    {
        Connection connection = getConnection();
        if (connection != null)
        {
            connection.rollback();
        }
    }

    //事务提交,关闭资源,从ThreadLocal中释放
    public static void commitAndRelease() throws SQLException
    {
        Connection connection = getConnection();
        if (connection != null)
        {
            connection.commit();
            connection.close();
            threadLocal.remove();//从线程绑定中移除
        }

    }

    //关闭资源方法
    public static void closeConnection() throws SQLException
    {
        Connection connection = getConnection();
        if (connection != null)
        {
            connection.close();
        }
    }

    //关闭声明语句
    public static void closeStatement(Statement statement) throws SQLException{
        if(statement!=null){
            statement.close();
        }
    }

    //关闭查询结果集
    public static void closeResultSet(ResultSet resultSet)throws SQLException{
        if(resultSet!=null){
            resultSet.close();
        }
    }
}
