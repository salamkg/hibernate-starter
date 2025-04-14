package com.test;

import com.test.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
//        cfg.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        cfg.addClass(User.class);
        cfg.configure();

        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .username("admin@admin.com")
                    .firstName("admin")
                    .lastName("admin")
                    .birthDate(LocalDate.of(20000, 10, 10))
                    .age(20)
                    .build();

            session.persist(user);

            session.getTransaction().commit();
            System.out.println("OK");
        }
    }
}