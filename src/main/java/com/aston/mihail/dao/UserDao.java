package com.aston.mihail.dao;

import com.aston.mihail.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements DaoUser{

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

    private static class SingletonHelper {
        private static final UserDao INSTANCE = new UserDao();
    }

    public static UserDao getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<User> find(String user_id) throws SQLException {

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, user_id);
            session.getTransaction().commit();
            return Optional.ofNullable(user);
        }
        finally {
            factory.close();
        }

    }

    @Override
    public boolean save(User user) throws SQLException {

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
        return true;
    }

    @Override
    public List<User> findAll() throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<User> userList = session.createQuery("from User", User.class)
                    .getResultList();

            session.getTransaction().commit();
            return userList;
        }
        finally {
            factory.close();
        }

    }

    @Override
    public boolean update(User user) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
        return true;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
        return true;
    }

    public boolean isValid(String login, String password) throws SQLException{
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<User> users = session.createQuery("from User" + "where login = " + login +
                    " and pasword = " + password).getResultList();
            if (!users.isEmpty()) {
                return true;
            }
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
        return false;
    }

}
