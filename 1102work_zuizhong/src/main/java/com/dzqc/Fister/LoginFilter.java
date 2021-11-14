package com.dzqc.Fister;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//登录过滤
@WebFilter(filterName = "login", value = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String requestURI = req.getRequestURI();
        if (requestURI.toLowerCase().contains("login") ||
                requestURI.toLowerCase().contains("reg") ||
                requestURI.toLowerCase().contains("check")) {
            filterChain.doFilter(req, resp);
            return;
        }
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {

            resp.sendRedirect(req.getContextPath() + "views/login.jsp");
        } else {
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}
