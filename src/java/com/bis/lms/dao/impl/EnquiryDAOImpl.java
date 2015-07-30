/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.dao.impl;

import com.bis.lms.dao.EnquiryDAO;
import com.bis.lms.entity.Enquiry;
import com.bis.lms.util.MySqlConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class EnquiryDAOImpl implements EnquiryDAO {
    private MySqlConnection conn;

    public EnquiryDAOImpl() {
        conn = new MySqlConnection();
    }
    

    @Override
    public List<Enquiry> getByMemberId(int memberId) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enquiry> getByBookId(int bookId) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Enquiry enquiry) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO tbl_enquiry(book_id, member_id) VALUES (?,?)";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setInt(1, enquiry.getBookId());
        pst.setInt(2, enquiry.getMemberId());
        return pst.executeUpdate();
    }

    @Override
    public int update(Enquiry enquiry) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO tbl_enquiry(status) VALUE (?)";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setBoolean(1, enquiry.getStatus());
        return pst.executeUpdate();
    }

    @Override
    public List<Enquiry> getAll() throws ClassNotFoundException, SQLException {
        List<Enquiry> enquiryList = new ArrayList<Enquiry>();
        String SQL = "SELECT * FROM tbl_enquiry";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        ResultSet rs = pst.executeQuery();
        Timestamp timeStamp = null;
        while(rs.next()){
            Enquiry enq = new Enquiry();
            enq.setBookId(rs.getInt("book_id"));
            enq.setMemberId(rs.getInt("member_id"));
            enq.setId(rs.getInt("id"));
            timeStamp = rs.getTimestamp("request_date");
            enq.setRequestDate(timeStamp);
            enq.setStatus(rs.getBoolean("status"));
            enquiryList.add(enq);
        }
        return enquiryList;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enquiry getById(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
