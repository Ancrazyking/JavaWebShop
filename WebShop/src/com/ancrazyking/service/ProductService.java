package com.ancrazyking.service;

import com.ancrazyking.bean.Category;
import com.ancrazyking.bean.PageBean;
import com.ancrazyking.bean.Product;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/23 14:03
 **/
public interface ProductService
{
     List<Product> findHotProductList()throws Exception;

    List<Product> findNewProductList()throws Exception;

    List<Category> findAllCategory()throws Exception;

    PageBean findProductListByCid(String cid,int currentPage,int currentCount)throws Exception;

    Product findProductByPid(String pid)throws Exception;
}
