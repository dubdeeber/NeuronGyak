package org.example.web;

import java.io.*;
import jakarta.servlet.http.*;

//@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("password")){
            HttpSession session = request.getSession();
            session.setAttribute("authenticated","true");
            response.sendRedirect(response.encodeRedirectURL("Secured/profile.html"));
    }else {
            response.sendRedirect("login.html");
        }

    }

    public void destroy() {

    }
}