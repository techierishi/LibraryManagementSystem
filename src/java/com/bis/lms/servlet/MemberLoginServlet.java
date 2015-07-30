/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.servlet;

import com.bis.lms.entity.Book;
import com.bis.lms.entity.Genre;
import com.bis.lms.entity.Member;
import com.bis.lms.service.BookService;
import com.bis.lms.service.GenreService;
import com.bis.lms.service.MemberService;
import com.bis.lms.service.impl.BookServiceImpl;
import com.bis.lms.service.impl.GenreServiceImpl;
import com.bis.lms.service.impl.MemberServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet (urlPatterns = "/memberLogin")
public class MemberLoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberService memberService = new MemberServiceImpl();        
        BookService bookService = new BookServiceImpl();
        Member member = null;
        List<Book> latestBookList, borrowedBookList = null;
        List<Genre> genreList = null;
        try {
            member = memberService.authenticate(req.getParameter("email"), req.getParameter("password"));
            if(member != null){
                
                latestBookList = bookService.getByLatestPublishedDate();                
                HttpSession session = req.getSession(true);
                session.setAttribute("memberLogin", true);
                session.setAttribute("member", member);
                session.setAttribute("latestBookList", latestBookList);                
                resp.sendRedirect(req.getContextPath()+"/member/memberDashboard.jsp");
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
