/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.dao.impl;

import com.bis.lms.dao.BookDAO;
import com.bis.lms.entity.Book;
import com.bis.lms.util.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDAOImpl implements BookDAO {
    private MySqlConnection conn;

    public BookDAOImpl() {
          conn = new MySqlConnection();
    }
    
    @Override
    public List<Book> getByAuthor(String authorName) throws ClassNotFoundException, SQLException{
        List<Book> bookList = new ArrayList<Book>();
        
        String SQL = "SELECT * FROM tbl_books WHERE author='?'";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setString(1, authorName);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setGenreId(rs.getInt("genre_id"));
            book.setPublishedDate(rs.getDate("published_date"));
            book.setStatus(rs.getBoolean("status"));
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Book> getByMostEnquiries()throws ClassNotFoundException, SQLException {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getByLatestPublishedDate() throws SQLException, ClassNotFoundException {
        List<Book> bookList = new ArrayList<Book>();
        String SQL = "SELECT tbl_books.id, tbl_books.title, tbl_books.author, tbl_books.published_date, tbl_books.status, tbl_genre.name "
                + "FROM tbl_books "
                + "LEFT JOIN tbl_genre "
                + "ON tbl_books.genre_id = tbl_genre.id "
                + "WHERE tbl_books.published_date>='1990-01-01'"
                + "ORDER BY tbl_books.published_date DESC";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));          
            book.setGenre(rs.getString("name"));
            book.setPublishedDate(rs.getDate("published_date"));
            book.setStatus(rs.getBoolean("status"));
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Book> getBorrowedBooks(int memberId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Book book) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO tbl_books(title, author, genre_id, published_date, status) VALUES (?,?,?,?,?)";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setString(1, book.getTitle());
        pst.setString(2, book.getAuthor());
        pst.setInt(3, book.getGenreId());
        pst.setDate(4, new java.sql.Date(book.getPublishedDate().getTime()));
        pst.setBoolean(5, true);
        return pst.executeUpdate();
    }

    @Override
    public int update(Book book) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO tbl_books(title, author, genre_id, published_date, status) VALUES (?,?,?,?,?) WHERE id=?";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setString(1, book.getTitle());
        pst.setString(2, book.getAuthor());
        pst.setInt(3, book.getGenreId());
        pst.setDate(4, new java.sql.Date(book.getPublishedDate().getTime()));
        pst.setBoolean(5, book.getStatus());
        pst.setInt(6, book.getId());
        return pst.executeUpdate();
    }

    @Override
    public List<Book> getAll() throws ClassNotFoundException, SQLException {
        List<Book> bookList = null;
        String SQL = "SELECT * FROM tbl_books";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setGenreId(rs.getInt("genre_id"));
            book.setPublishedDate(rs.getDate("published_date"));
            book.setStatus(rs.getBoolean("status"));
            bookList.add(book);
        }
        return(bookList);
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String SQL = "DELETE FROM tbl_books WHERE id=?";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setInt(1, id);
        return pst.executeUpdate();
    }

    @Override
    public Book getById(int id) throws ClassNotFoundException, SQLException {
        Book book = null;
        String SQL = "SELECT FROM tbl_books WHERE id=?";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            book = new Book();
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setGenreId(rs.getInt("genre_id"));
            book.setPublishedDate(rs.getDate("published_date"));
            book.setStatus(rs.getBoolean("status"));            
        }
        return book;
    }
    
}
