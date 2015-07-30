/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.dao.impl;

import com.bis.lms.dao.AdminDAO;
import com.bis.lms.entity.Admin;
import com.bis.lms.util.Mail;
import com.bis.lms.util.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminDAOImpl implements AdminDAO {
    private MySqlConnection conn;
    private Mail sendMail;

    public AdminDAOImpl() {
        conn = new MySqlConnection();
        sendMail = new Mail();
    }
   

    @Override
    public int insert(Admin admin) throws ClassNotFoundException, SQLException {
        int i=0;
        String SQL = "SELECT * FROM tbl_admin WHERE email=?";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        pst.setString(1, admin.getEmail());
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            conn.close();
            return i;
        }
        else{
            SQL = "INSERT INTO tbl_admin(fname, lname, email, password) VALUES(?,?,?,?)";
            conn.open();
            pst = conn.initStatement(SQL);
            pst.setString(1, admin.getFname());
            pst.setString(2, admin.getLname());
            pst.setString(3, admin.getEmail());
            pst.setString(4, admin.getPassword());
            conn.close();
            i = pst.executeUpdate();
            sendMail.sendMail(admin.getEmail(),"You have been added as an admin", "Dear User,\n You have been added as an admin.\nAdmin,\nCitizen Library\n\nDo not reply to this email.");
            return i;
        }
    }

    @Override
    public int update(Admin admin) throws ClassNotFoundException, SQLException {
        String SQL = "UPDATE tbl_admin(fname, lname, email, password) VALUES(?,?,?,?)";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        pst.setString(1, admin.getFname());
        pst.setString(2, admin.getLname());
        pst.setString(3, admin.getEmail());
        pst.setString(4, admin.getPassword());
        conn.close();
        return pst.executeUpdate();
    }

    @Override
    public List<Admin> getAll() throws ClassNotFoundException, SQLException {
        List<Admin> adminList = new ArrayList<Admin>();
        String SQL = "SELECT * FROM tbl_admin";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Admin admin = new Admin();
            admin.setFname(rs.getString("fname"));
            admin.setLname(rs.getString("lname"));
            admin.setEmail(rs.getString("email"));
            admin.setPassword(rs.getString("password"));
            adminList.add(admin);
        }
        return adminList;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

    @Override
    public Admin getById(int id) throws ClassNotFoundException, SQLException {
        Admin admin=null;
        String SQL = "SELECT * FROM tbl_admin WHERE id=?";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            admin = new Admin();
            admin.setFname(rs.getString("fname"));
            admin.setLname(rs.getString("lname"));
            admin.setEmail(rs.getString("email"));
            admin.setPassword(rs.getString("password"));
        }
        return admin;
    }

    @Override
    public Admin authenticate(String email, String password) throws SQLException, ClassNotFoundException {
        Admin admin=null;
        String SQL = "SELECT * FROM tbl_admin WHERE email=? AND password=?";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setString(1, email);
        pst.setString(2, password);
              
        ResultSet rs =  pst.executeQuery();
        while(rs.next()){
            admin = new Admin();
            admin.setFname(rs.getString("fname"));
            admin.setLname(rs.getString("lname"));
            admin.setEmail(rs.getString("email"));
            admin.setPassword(rs.getString("password"));
        }
        return admin;
    }
    
}
