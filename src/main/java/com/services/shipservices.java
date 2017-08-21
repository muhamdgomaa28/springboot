package com.services;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.shipdao;
import com.model.Shipwreck;

@Service
public class shipservices {
    

    @Autowired
    shipdao sDao;
    public void insertship(Shipwreck s) {
    	
    	sDao.insert(s);
    	
    }
    public List<Shipwreck> getAll(String id) {


        return sDao.getAll(id);


    }

//    public void update(Shipwreck Shipwreck) {
//    	sDao.update(Shipwreck);
//    }
//
//    public void Delete(String courseId) {
//    	sDao.Delete(courseId);
//
//    }

    public Shipwreck getSpecific(String id) {

        return sDao.getSpecific(id);
    }

    
    }