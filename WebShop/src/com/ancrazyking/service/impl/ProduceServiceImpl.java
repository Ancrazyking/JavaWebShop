package com.ancrazyking.service.impl;

import com.ancrazyking.bean.Category;
import com.ancrazyking.bean.PageBean;
import com.ancrazyking.bean.Product;
import com.ancrazyking.dao.ProductDao;
import com.ancrazyking.dao.impl.ProductDaoImpl;
import com.ancrazyking.service.ProductService;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/23 14:03
 **/
public class ProduceServiceImpl implements ProductService
{
    private ProductDao productDao=new ProductDaoImpl();
    //查询热门商品
    @Override
    public List<Product> findHotProductList()throws Exception
    {
        List<Product> hotProductList=null;
        hotProductList=productDao.findHotProductList();

        return hotProductList;
    }

    //查询最新商品
    @Override
    public List<Product> findNewProductList()throws Exception
    {
        List<Product> newProductList=null;
        newProductList=productDao.findNewProductList();
        return newProductList;
    }

    //查询所有种类
    @Override
    public List<Category> findAllCategory()throws Exception
    {
        List<Category> categoryList=null;
        categoryList=productDao.findAllCategory();
        return categoryList;
    }

    //通过商品id查询商品
    @Override
    public Product findProductByPid(String pid)throws Exception
    {
       Product product=null;
       product=productDao.findProductByPid(pid);
        return product;
    }

    //查询商品列表分页查询
    @Override
    public PageBean findProductListByCid(String cid, int currentPage, int currentCount) throws Exception
    {
        //封装一个PageBean返回web层
        PageBean<Product> pageBean=new PageBean<>();

        //1.封装当前页
        pageBean.setCurrentPage(currentPage);
        //2.每页显示的条数
        pageBean.setCurrentCount(currentCount);
        //3.总条数
        int totalCount=0;
        totalCount=productDao.getCount(cid);
        pageBean.setTotalCount(totalCount);
        //4.封装总页数
        int totalPage=(int)Math.ceil(1.0*totalCount/currentCount);
        pageBean.setTotalPage(totalPage);


        //5.当前显示的数据
        //当前页与起始索引index的关系
        int index=(currentPage-1)*currentCount;
        List<Product> list=null;
        list=productDao.findProductByPage(cid,index,currentCount);
        pageBean.setList(list);

        return  pageBean;
    }
}
