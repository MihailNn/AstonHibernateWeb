package com.aston.mihail.dao;

import com.aston.mihail.model.User;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataSourceHibernate {
    private static SessionFactory sessionFactory;


    static {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(User.class);
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private DataSourceHibernate() {
    }

    public static Session getCurrentSession() {
        return sessionFactory.openSession();
    }

//    SessionFactory factory = new Configuration()
//            .configure("hibernate.cfg.xml")
//            .addAnnotatedClass(User.class)
//            .buildSessionFactory();

}