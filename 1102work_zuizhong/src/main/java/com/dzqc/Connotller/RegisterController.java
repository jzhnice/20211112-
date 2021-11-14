package com.dzqc.Connotller;

import com.dzqc.Service.BaseService;
import com.dzqc.Service.impl.UserServiceImpl;
import com.dzqc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//注册   注册成功之后的重定向有问题
@WebServlet(name = "reg",value = "/reg")
public class RegisterController extends HttpServlet {
    private BaseService service = new UserServiceImpl();


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        if (uname == null || pwd == null||email == null
            || "".equals(uname) || "".equals(pwd)||"".equals(email)){
            resp.sendRedirect(req.getContextPath()+"/views/register.jsp");
            return;
        }
        User user = new User();
        user.setUserName(uname);
        user.setPassword(pwd);
        user.setEmail(email);
        Long add = service.add(user);
        if (add !=null && add>=1){
            resp.sendRedirect(req.getContextPath()+"/views/Login.jsp");
            return;
        }else{
            resp.sendRedirect(req.getContextPath()+"/views/register.jsp");
            return;
        }

    }
}