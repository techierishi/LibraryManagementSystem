/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bis.lms.service.impl;

import com.bis.lms.dao.GenreDAO;
import com.bis.lms.dao.impl.GenreDAOImpl;
import com.bis.lms.entity.Genre;
import com.bis.lms.service.GenreService;
import java.sql.SQLException;
import java.util.List;


public class GenreServiceImpl implements GenreService {
    private GenreDAO genreDAO ;

    public GenreServiceImpl() {
        genreDAO = new GenreDAOImpl();
    }

    @Override
    public int insert(Genre genre) throws ClassNotFoundException, SQLException {
        return genreDAO.insert(genre);
    }

    @Override
    public int update(Genre t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Genre> getAll() throws ClassNotFoundException, SQLException {
        return genreDAO.getAll();
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Genre getById(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
