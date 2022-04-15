package com.aston.mihail.dao;

import com.aston.mihail.model.Owner;
import com.aston.mihail.model.Pet;
import com.aston.mihail.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PetDao implements DaoPet{
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Pet.class)
            .buildSessionFactory();


    private static class SingletonHelper {
        private static final PetDao INSTANCE = new PetDao();
    }

    public static PetDao getInstance() {
        return PetDao.SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<Pet> find(String pet_id) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Pet pet = session.get(Pet.class, pet_id);
            session.getTransaction().commit();
            return Optional.ofNullable(pet);
        }
        finally {
            factory.close();
        }
    }

    @Override
    public List<Pet> findAll() throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Pet> petList = session.createQuery("from Pet", Pet.class)
                    .getResultList();

            session.getTransaction().commit();
            return petList;
        }
        finally {
            factory.close();
        }
    }

    @Override
    public boolean save(Pet pet) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(pet);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
        return true;
    }

    @Override
    public boolean update(Pet pet) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.update(pet);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
        return true;
    }

    @Override
    public boolean delete(Pet pet) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(pet);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
        return true;
    }
}
