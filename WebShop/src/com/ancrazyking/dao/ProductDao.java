package com.ancrazyking.dao;

import com.ancrazyking.bean.Product;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/23 11:26
 **/
public interface ProductDao
{
    List<Product> findHotProductList();

    List<Product> findNewProductList();



}
