/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.service;

import com.bis.lms.entity.Admin;
import java.sql.SQLException;

/**
 *
 * @author Bishal
 */
public interface AdminService extends GenericService<Admin> {
    public Admin authenticate(String email, String password) throws SQLException, ClassNotFoundException;
    
}
