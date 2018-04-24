package com.ancrazyking.web.servlet;

import com.ancrazyking.bean.Product;
import com.ancrazyking.service.ProductService;
import com.ancrazyking.service.impl.ProduceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/23 11:09
 * 首页的显示
 **/
public class IndexServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ProductService productService = new ProduceServiceImpl();

        //显示热门商品
        //显示最新商品
        try
        {
            List<Product> hotProductList = productService.findHotProductList();
            List<Product> newProductList = productService.findNewProductList();
            request.setAttribute("hotProductList", hotProductList);
            request.setAttribute("newProductList", newProductList);

            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
