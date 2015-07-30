/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.entity;

import java.sql.Timestamp;

/**
 *
 * @author Bishal
 */
public class Enquiry {
    private int id;
    private int bookId;
    private int memberId;
    private Timestamp requestDate;
    private Boolean status;

    public Enquiry() {
    }

    public Enquiry(int id, int bookId, int memberId, Timestamp requestDate, Boolean status) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
