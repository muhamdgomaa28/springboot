package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.model.Shipwreck;

@Transactional
@Component
public class shipdao {
    @Autowired
    private SessionFactory sessionFactory;

    public void insert(Shipwreck sh) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sh);
        transaction.commit();
        session.flush(); //address will not get saved without this

    }
    

    public List<Shipwreck> getAll(String id) {


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Shipwreck> Shipwreck = session.createCriteria(Shipwreck.class).add(Restrictions.eq("id", id)).list();

        transaction.commit();
        session.flush(); //address will not get saved without this

        return Shipwreck;

    }
    public Shipwreck getSpecific(String id) {


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Shipwreck Shipwreck = (Shipwreck) session.createCriteria(Shipwreck.class).add(Restrictions.eq("id", id)).uniqueResult();

        transaction.commit();
        session.flush();

        return Shipwreck;

    }







}