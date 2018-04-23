package com.ancrazyking.web.servlet;

import com.ancrazyking.bean.User;
import com.ancrazyking.service.UserService;
import com.ancrazyking.service.impl.UserServiceImpl;
import com.ancrazyking.utils.MailUtils;
import com.ancrazyking.utils.UUIDutils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Ancrazyking
 * @date 2018/4/22 20:56
 **/
public class RegisterServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        //获得表单数据
        Map<String,String[]> properties=request.getParameterMap();
        User user=new User();
        try{
            //给自己指定一个类型转换器(将String转换为Date)
            ConvertUtils.register(new Converter(){
                @Override
                public Object convert(Class clazz, Object value)
                {
                    //将string转成date
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                    Date parse=null;
                    try{
                        parse=format.parse(value.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return parse;
                }
            },Date.class);
            //映射封装
            BeanUtils.populate(user,properties);
        }catch (Exception e){
            e.printStackTrace();
        }

        user.setUid(UUIDutils.getUUID());
        user.setTelephone(null);
        user.setState(0);
        String activeCode=UUIDutils.getUUID();
        user.setCode(activeCode);

        //将user传递给service层
        UserService userService=new UserServiceImpl();
        boolean isRegisterSuccess=userService.register(user);


        //是否注册成功
        if(isRegisterSuccess){
            //发送激活邮件
            String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
                    + "<a href='http://localhost:808/active?activeCode="+activeCode+"'>"
                    + "http://localhost:8080/active?activeCode="+activeCode+"</a>";
            try{
                MailUtils.sendMail(user.getEmail(),emailMsg);
            }catch (Exception e){
                e.printStackTrace();
            }

            //跳转到注册成功页面
            response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/registerFail.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }
}
