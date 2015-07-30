/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.servlet;


import com.bis.lms.entity.Admin;
import com.bis.lms.service.AdminService;
import com.bis.lms.service.impl.AdminServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bishal
 */
@WebServlet (urlPatterns = "/adminLogin")
public class AdminLoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        Admin admin=null;
        try {
            admin = adminService.authenticate(req.getParameter("email"), req.getParameter("password"));
            if(admin!= null){
                HttpSession session = req.getSession(true);
                session.setAttribute("adminLogin", true);
                session.setAttribute("admin", admin);
                resp.sendRedirect(req.getContextPath()+"/admin/adminDashboard.jsp");
            }
             else{
                resp.sendRedirect(req.getContextPath()+"?error=loginError");
                }
        } catch (SQLException ex) {
            Logger.getLogger(AdminLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
