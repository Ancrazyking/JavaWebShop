package com.ancrazyking.web.servlet;

import com.ancrazyking.service.UserService;
import com.ancrazyking.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ancrazyking
 * @date 2018/4/23 10:13
 **/
public class ActiveServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       String activeCode=request.getParameter("activeCode");//获得的参数在传到的参数里面
        UserService userService=new UserServiceImpl();
        userService.active(activeCode);


        //跳转到登录页面
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(requset,response);
    }
}
