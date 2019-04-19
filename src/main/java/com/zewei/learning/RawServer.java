package com.zewei.learning;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RawServer extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("getQueryString:" + req.getQueryString() + "\n");
        resp.getWriter().append("getPathInfo:" + req.getPathInfo() + "\n");
        resp.getWriter().append("getServletPath:" + req.getServletPath() + "\n");
        resp.getWriter().append("getContextPath:" + req.getContextPath() + "\n");
        resp.getWriter().append("getRequestURL:" + req.getRequestURL()+ "\n");
        resp.getWriter().append("getRequestURI:" + req.getRequestURI()+ "\n");
        resp.getWriter().append("getServerName:" + req.getServerName()+ "\n");
    }
}
