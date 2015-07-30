/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.dao.impl;

import com.bis.lms.dao.MemberDAO;
import com.bis.lms.entity.Member;
import com.bis.lms.util.Mail;
import com.bis.lms.util.MySqlConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class MemberDAOImpl implements MemberDAO {
    private MySqlConnection conn;
    private Mail mail;

    public MemberDAOImpl() {
        conn = new MySqlConnection();
        mail = new Mail();
    }
    
    @Override
    public int insert(Member member) throws ClassNotFoundException, SQLException {
        int i=0;
        String SQL = "SELECT * FROM tbl_member WHERE email=?";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        pst.setString(1, member.getEmail());
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            conn.close();
            return i;
        }
        else{
        
        SQL = "INSERT INTO tbl_member(fname, lname, email, password, status) VALUES (?,?,?,?,?)";
        conn.open();
        pst = conn.initStatement(SQL);
        conn.close();
        pst.setString(1, member.getFname());
        pst.setString(2, member.getLname());
        pst.setString(3, member.getEmail());
        pst.setString(4, member.getPassword());
        pst.setBoolean(5, member.getStatus());
        i =pst.executeUpdate();
        mail.sendMail(member.getEmail(),
                "Confirmation of Membership of Citizen Libarary!",
                "Dear Subscriber,\n Thank you for your subscription.\nAdmin,\nCitizen Library\n\nDo not reply to this email.");
        return i;
        }
    }

    @Override
    public int update(Member member) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO tbl_member(fname, lname, email, password, status) VALUES (?,?,?,?,?) WHERE id=?";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setString(1, member.getFname());
        pst.setString(2, member.getLname());
        pst.setString(3, member.getEmail());
        pst.setString(4, member.getEmail());
        pst.setBoolean(5, member.getStatus());
        pst.setInt(6, member.getId());
       
        return pst.executeUpdate();
    }

    @Override
    public List<Member> getAll() throws ClassNotFoundException, SQLException {
        List<Member> memberList = new ArrayList<Member>();
        Timestamp admissionDate = null;
        
        String SQL = "SELECT * FROM tbl_member";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Member member = new Member();
            member.setId(rs.getInt("id"));
            member.setFname(rs.getString("fname"));
            member.setLname(rs.getString("lname"));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("password"));
            admissionDate = rs.getTimestamp("admission_date");
            member.setAdmissionDate(admissionDate);
            member.setStatus(rs.getBoolean("status"));
            memberList.add(member);
        }
        return memberList;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String SQL = "DELETE FROM tbl_member WHERE id=?";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setInt(1, id);
        return pst.executeUpdate();
    }

    @Override
    public Member getById(int id) throws ClassNotFoundException, SQLException {
        Member member = null;
        Timestamp admissionDate = null;
        String SQL = "SELECT FROM tbl_member WHERE id=?";
        
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            member = new Member();
            member.setId(rs.getInt("id"));
            member.setFname(rs.getString("fname"));
            member.setLname(rs.getString("lname"));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("password"));
            admissionDate = rs.getTimestamp("admission_date");
            member.setAdmissionDate(admissionDate);
            member.setStatus(rs.getBoolean("status"));            
        }
        return member;
    }

    @Override
    public Member authenticate(String email, String password) throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM tbl_member WHERE email=? AND password=?";
        Member member = null;
        Timestamp admissionDate = null;
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setString(1, email);
        pst.setString(2, password);
              
        ResultSet rs =  pst.executeQuery();
        while(rs.next()){
            member = new Member();
            member.setId(rs.getInt("id"));
            member.setFname(rs.getString("fname"));
            member.setLname(rs.getString("lname"));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("password"));
            admissionDate = rs.getTimestamp("admission_date");
            member.setAdmissionDate(admissionDate);
            member.setStatus(rs.getBoolean("status"));       
        }
        return member;
    }
    
}
