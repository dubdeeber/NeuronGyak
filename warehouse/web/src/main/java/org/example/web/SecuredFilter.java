package org.example.web;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = {"/Secured/*"})
public class SecuredFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpRequest.getSession();
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if(httpSession.getAttribute("authenticated").equals("true")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{

            httpServletResponse.sendRedirect(httpServletResponse.encodeRedirectURL("/web_war_exploded/login.html"));

        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
}
