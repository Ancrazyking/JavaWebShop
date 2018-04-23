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
 * @date 2018/4/23 10:19
 **/
public class CheckUsernameServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获得用户名
        String username = request.getParameter("username");

        UserService userService = new UserServiceImpl();
        boolean isExist = userService.checkUsername(username);
        String json = "{\"isExist\":" + isExist + "}";
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
