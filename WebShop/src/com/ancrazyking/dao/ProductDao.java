package com.ancrazyking.dao;

import com.ancrazyking.bean.Category;
import com.ancrazyking.bean.Product;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/23 11:26
 **/
public interface ProductDao
{
    List<Product> findHotProductList()throws Exception;

    List<Product> findNewProductList()throws Exception;


    List<Category> findAllCategory()throws Exception;

    int getCount(String cid)throws Exception;


    List<Product> findProductByPage(String cid,int index,int currentCount)throws Exception;

    Product findProductByPid(String pid) throws Exception;
}
