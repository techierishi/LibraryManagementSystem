/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.service.impl;

import com.bis.lms.dao.AdminDAO;
import com.bis.lms.dao.impl.AdminDAOImpl;
import com.bis.lms.entity.Admin;
import com.bis.lms.service.AdminService;
import java.sql.SQLException;
import java.util.List;


public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = null;

    public AdminServiceImpl() {
        adminDAO = new AdminDAOImpl();
    }
    

    @Override
    public int insert(Admin admin) throws ClassNotFoundException, SQLException {
        return adminDAO.insert(admin);
    }

    @Override
    public int update(Admin admin) throws ClassNotFoundException, SQLException {
       return adminDAO.update(admin);
    }

    @Override
    public List<Admin> getAll() throws ClassNotFoundException, SQLException {
        return adminDAO.getAll();
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        return adminDAO.delete(id);
    }

    @Override
    public Admin getById(int id) throws ClassNotFoundException, SQLException {
        return adminDAO.getById(id);
    }

    @Override
    public Admin authenticate(String email, String password) throws SQLException, ClassNotFoundException {
        return adminDAO.authenticate(email, password);
    }
    
}
