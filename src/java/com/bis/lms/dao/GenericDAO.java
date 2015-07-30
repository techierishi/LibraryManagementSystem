/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Bishal
 */
public interface GenericDAO<T> {
    public int insert(T t) throws ClassNotFoundException, SQLException;
    public int update(T t) throws ClassNotFoundException, SQLException;
    public List<T> getAll() throws ClassNotFoundException, SQLException;
    public int delete(int id) throws ClassNotFoundException, SQLException;
    public T getById (int id) throws ClassNotFoundException, SQLException;
}
