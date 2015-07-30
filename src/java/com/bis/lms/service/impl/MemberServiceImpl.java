/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.service.impl;

import com.bis.lms.dao.MemberDAO;
import com.bis.lms.dao.impl.MemberDAOImpl;
import com.bis.lms.entity.Member;
import com.bis.lms.service.MemberService;
import java.sql.SQLException;
import java.util.List;


public class MemberServiceImpl implements MemberService {
    private MemberDAO memberDAO = null;

    public MemberServiceImpl() {
        memberDAO = new MemberDAOImpl();
    }
    

    @Override
    public int insert(Member member) throws ClassNotFoundException, SQLException {
        return memberDAO.insert(member);
    }

    @Override
    public int update(Member member) throws ClassNotFoundException, SQLException {
        return memberDAO.update(member);
    }

    @Override
    public List<Member> getAll() throws ClassNotFoundException, SQLException {
        return memberDAO.getAll();
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        return memberDAO.delete(id);
    }

    @Override
    public Member getById(int id) throws ClassNotFoundException, SQLException {
        return memberDAO.getById(id);
    }

    @Override
    public Member authenticate(String email, String password) throws SQLException, ClassNotFoundException {
        return memberDAO.authenticate(email, password);
    }
    
}
