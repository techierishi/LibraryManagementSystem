/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.service.impl;

import com.bis.lms.dao.BookDAO;
import com.bis.lms.dao.impl.BookDAOImpl;
import com.bis.lms.entity.Book;
import com.bis.lms.service.BookService;
import java.sql.SQLException;
import java.util.List;


public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = null;

    public BookServiceImpl() {
        bookDAO = new BookDAOImpl();
    }
    
    
    @Override
    public List<Book> getByAuthor(String authorName) throws ClassNotFoundException, SQLException {
        return bookDAO.getByAuthor(authorName);
    }

    @Override
    public List<Book> getByMostEnquiries() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getByLatestPublishedDate() throws ClassNotFoundException, SQLException {
        return bookDAO.getByLatestPublishedDate();
    }

    @Override
    public List<Book> getBorrowedBooks(int memberId) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Book book) throws ClassNotFoundException, SQLException {
        return bookDAO.insert(book);
    }

    @Override
    public int update(Book book) throws ClassNotFoundException, SQLException {
        return bookDAO.update(book);
    }

    @Override
    public List<Book> getAll() throws ClassNotFoundException, SQLException {
        return bookDAO.getAll();
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        return bookDAO.delete(id);
    }

    @Override
    public Book getById(int id) throws ClassNotFoundException, SQLException {
        return bookDAO.getById(id);
    }
    
}
