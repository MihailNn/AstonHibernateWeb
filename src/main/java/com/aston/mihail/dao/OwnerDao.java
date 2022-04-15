package com.aston.mihail.dao;

import com.aston.mihail.model.Owner;
import com.aston.mihail.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OwnerDao implements DaoOwner {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Owner.class)
            .buildSessionFactory();


    private static class SingletonHelper {
        private static final OwnerDao INSTANCE = new OwnerDao();
    }

    public static OwnerDao getInstance() {
        return OwnerDao.SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<Owner> find(String owner_id) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Owner owner = session.get(Owner.class, owner_id);
            session.getTransaction().commit();
            return Optional.ofNullable(owner);
        }
        finally {
            factory.close();
        }
    }

    @Override
    public List<Owner> findAll() throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Owner> ownerList = session.createQuery("from Owner", Owner.class)
                    .getResultList();

            session.getTransaction().commit();
            return ownerList;
        }
        finally {
            factory.close();
        }
    }

    @Override
    public boolean save(Owner owner) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(owner);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
        return true;
    }

    @Override
    public boolean update(Owner owner) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.update(owner);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
        return true;
    }

    @Override
    public boolean delete(Owner owner) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(owner);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
        return true;
    }
}
