package org.example.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login-servlet-async")
public class LoginServletAsync extends HttpServlet {

    private Gson gson;

    public void init() {
    gson=new GsonBuilder().setPrettyPrinting().create();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("password")){
            session.setAttribute("authenticated","true");
            session.setAttribute("result", true);
        }else {
            session.setAttribute("authenticated", false);
            session.setAttribute("result", false);
        }
        String jsonOut = gson.toJson(session);
        response.getWriter().write(jsonOut);
        out.flush();

    }
    public void destroy() {
    }
}
