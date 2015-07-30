/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.servlet;

import com.bis.lms.entity.Book;
import com.bis.lms.entity.Genre;
import com.bis.lms.service.BookService;
import com.bis.lms.service.GenreService;
import com.bis.lms.service.impl.BookServiceImpl;
import com.bis.lms.service.impl.GenreServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(urlPatterns = "/addBook")
public class AdminAddBookServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               
        List<Genre> genreList = new ArrayList<Genre>();
        GenreService gs = new GenreServiceImpl();
        try {
            for(Genre g:(gs.getAll())){
                genreList.add(g);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminAddBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminAddBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Genre g: genreList){
            System.out.println(g.getName());
        }
        req.setAttribute("genreList", genreList);
        req.setAttribute("test", true);
        req.getRequestDispatcher("/admin/addBook.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        Book book = new Book();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("published_date"));
            System.out.println(date);
        } catch (ParseException ex) {
            Logger.getLogger(AdminAddBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        book.setTitle(req.getParameter("title"));
        book.setAuthor(req.getParameter("author"));
        book.setGenreId(Integer.parseInt(req.getParameter("genre_id")));
        book.setPublishedDate(date);
        
        try {
            bookService.insert(book);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminAddBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminAddBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(req.getContextPath()+"/admin/addBook.jsp?success=true");
    }
    
    
}
