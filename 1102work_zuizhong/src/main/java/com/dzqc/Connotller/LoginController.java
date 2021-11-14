package com.dzqc.Connotller;
import com.dzqc.Service.BaseService;
import com.dzqc.Service.impl.UserServiceImpl;
import com.dzqc.entity.User;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
    private BaseService service = new UserServiceImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        if (uname == null && uname.equals("") || pwd == null || pwd.equals("")) {
            resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
        }

        User user = new User();
        user.setUserName(uname);
        user.setPassword(pwd);

        List querr = service.querr(user);
        if (querr.isEmpty()){
            resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
        }
        else{
            req.getSession().setAttribute("user",querr.get(0));

            resp.sendRedirect(req.getContextPath() + "/user");

        }
    }
}
