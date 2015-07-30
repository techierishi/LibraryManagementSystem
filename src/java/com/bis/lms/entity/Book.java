/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.entity;

import java.util.Date;

/**
 *
 * @author Bishal
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private int genreId;
    private String genre;
    private Date publishedDate;
    private Boolean status;

    public Book() {
    }

    public Book(int id, String title, String author, int genreId,String genre, Date publishedDate, Boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genreId = genreId;
        this.genre = genre;
        this.publishedDate = publishedDate;
        this.status = status;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
    
}
