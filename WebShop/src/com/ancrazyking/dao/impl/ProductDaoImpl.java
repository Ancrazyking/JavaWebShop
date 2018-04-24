package com.ancrazyking.dao.impl;

import com.ancrazyking.bean.Category;
import com.ancrazyking.bean.Product;
import com.ancrazyking.dao.ProductDao;
import com.ancrazyking.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/23 14:02
 **/
public class ProductDaoImpl implements ProductDao
{
    @Override
    public List<Product> findHotProductList()throws Exception
    {
        QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
        String sql="select * from product where is_hot=? limit ?,?";
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);

    }

    @Override
    public List<Product> findNewProductList()throws Exception
    {
        QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
        String sql="select * from product order by pdate desc limit ?,?";
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class),0,9);
    }

    @Override
    public List<Category> findAllCategory()throws Exception
    {
        QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
        String sql="select * from category";
        return queryRunner.query(sql,new BeanListHandler<Category>(Category.class));
    }

    @Override
    public int getCount(String cid)throws Exception
    {

        QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
        String sql="select count(*) from product where cid=?";
        return (int)queryRunner.query(sql,new ScalarHandler(),cid);//代表查询条数的方法
    }

    @Override
    public List<Product> findProductByPage(String cid, int index, int currentCount)throws Exception
    {
        QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
        String sql="select * from product where cid=? limit ?,?";
        return (List<Product>)queryRunner.query(sql,new BeanHandler<Product>(Product.class),cid,index,currentCount);
    }

    @Override
    public Product findProductByPid(String pid)throws Exception
    {
        QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
        String sql="select * from product where pid=?";
        return queryRunner.query(sql,new BeanHandler<Product>(Product.class),pid);
    }
}
