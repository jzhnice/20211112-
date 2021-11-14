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
import java.util.List;

@WebServlet(name = "user",value = "/user")
public class UserController extends HttpServlet {
    private BaseService service = new UserServiceImpl();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(1111);
        List<User> list = service.querrAll();
        req.setAttribute("users",list);
        req.getRequestDispatcher("views/list.jsp").forward(req,resp);

    }




    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(222);
        String todo = req.getParameter("todo");
        if (todo.equals("upd")){
            userUpd(req,resp);
        }
        else if(todo.equals("del")){
            userDel(req,resp);
        }
    }

    private void userDel(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        String uname = req.getParameter("uname");
        if (uname == null || uname.equals("")){
            resp.sendRedirect(req.getContextPath()+"/views/remove.jsp");
            return;
        }
        User user = new User();
        user.setUserName(uname);
        Integer remove = service.remove(user);
        if (remove>=1){
            doGet(req,resp);
            return;
        }else{
            resp.sendRedirect(req.getContextPath()+"/views/remove.jsp");
            return;
        }
    }

    private void userUpd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("userid");
        if (uid == null || uid.equals("")){
            resp.sendRedirect(req.getContextPath()+"/views/edit.jsp");
            return;
        }
        String uname = req.getParameter("uname");

        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        User user = new User();
        user.setUserName(uname);
        user.setPassword(pwd);
        user.setEmail(email);
        user.setId(Long.parseLong(uid));
        Integer edit = service.edit(user);
        if (edit>=1){
            doGet(req,resp);
            return;
        }else{
            resp.sendRedirect(req.getContextPath()+"/views/edit.jsp");
            return;
        }
    }

}
