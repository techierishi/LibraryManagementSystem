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
public class Member {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private Timestamp admissionDate;
    private Boolean status;

    public Member() {
    }

    public Member(int id, String fname, String lname, String email, String password, Timestamp admissionDate, Boolean status) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Timestamp admissionDate) {
        this.admissionDate = admissionDate;
    }

    
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
