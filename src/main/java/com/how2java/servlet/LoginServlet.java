package com.how2java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        System.out.println("LoginServlet 构造方法 被调用");
    }

    public void init(ServletConfig config) {
        System.out.println("init(ServletConfig)");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String name = request.getParameter("name");
        String password = request.getParameter("password");

        System.out.println("浏览器发出的请求时的完整URL,包括协议 主机名 端口（如果有）：" + request.getRequestURL());
        System.out.println("浏览器发出的请求的资源名部分,去掉协议和主机名：" + request.getRequestURI());
        System.out.println("浏览器行中的参数部分：" + request.getQueryString());
        System.out.println("浏览器所处的客户机的IP地址" + request.getRemoteAddr());
        System.out.println("浏览器所处的客户机使用的主机名：" + request.getRemoteHost());
        System.out.println("浏览器所处的客户机使用的网络端口：" + request.getRemotePort());
        System.out.println("服务器的ip地址" + request.getLocalAddr());
        System.out.println("服务器的主机名：" + request.getLocalName());
        System.out.println("得到客户机的请求方式：" + request.getMethod());

        String html = null;


        if ("admin".equals(name) && "123".equals(password)) {
            request.getRequestDispatcher("successful.html").forward(request, response);
        } else {
            response.setStatus(301);


            response.sendRedirect("fail.html");

            response.setContentType("text/html; charset=UTF-8");


            System.out.println("name:" + name);
            System.out.println("password:" + password);
        }
    }
}