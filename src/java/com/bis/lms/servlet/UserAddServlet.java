/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.servlet;

import com.bis.lms.entity.Admin;
import com.bis.lms.entity.Member;
import com.bis.lms.service.AdminService;
import com.bis.lms.service.MemberService;
import com.bis.lms.service.impl.AdminServiceImpl;
import com.bis.lms.service.impl.MemberServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bishal
 */
@WebServlet("/addUser")
public class UserAddServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Add a new User");
        if(req.getParameter("type").equals("admin")){
            req.getRequestDispatcher("/admin/addAdmin.jsp").forward(req, resp);
        }
        if(req.getParameter("type").equals("member")){
            req.getRequestDispatcher("/member/addMember.jsp").forward(req, resp);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("type").equals("admin")){
            AdminService adminService = new AdminServiceImpl();
            Admin admin = new Admin();
            admin.setFname(req.getParameter("fname"));
            admin.setLname(req.getParameter("lname"));
            admin.setEmail(req.getParameter("email"));
            admin.setPassword(req.getParameter("password"));
            
            try {
                if(adminService.insert(admin)==0){
                    System.out.println("Email exists");
                    req.setAttribute("error", "Email exists");
                    req.getRequestDispatcher("/admin/addAdmin.jsp?error=");
                }
                else{
            resp.sendRedirect(req.getContextPath());}
                                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserAddServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserAddServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(req.getParameter("type").equals("member")){
            MemberService memberService = new MemberServiceImpl();
            Member member = new Member();
            member.setFname(req.getParameter("fname"));
            member.setLname(req.getParameter("lname"));
            member.setEmail(req.getParameter("email"));
            member.setPassword(req.getParameter("password"));
            member.setStatus(Boolean.TRUE);
            try {
                memberService.insert(member);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserAddServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserAddServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            resp.sendRedirect(req.getContextPath());
        }
         
    }
    
    
    
    
}
