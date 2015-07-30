/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.filter;

import java.io.IOException;
import java.util.jar.Attributes;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bishal
 */
@WebFilter(
        filterName = "adminAuthFilter",
        urlPatterns = "/admin/*")
public class AdminAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        Boolean isAuthenticated = false;
        HttpSession session = req.getSession();
        if(session!=null){
            if (session.getAttribute("admin")!=null) {
                isAuthenticated=true;
            }
        }
        if(!isAuthenticated){
            resp.sendRedirect(req.getContextPath());
        }
        else{
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        
    }
    
}
