package com.test;

import com.test.entity.*;
import com.test.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Google")
                .build();
        User user = User.builder()
                .username("jack111@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .firstName("Jack")
                        .lastName("Smith")
                        .birthDate(new Birthday(LocalDate.of(1990, 1, 1)))
                        .build())
                .company(company)
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             ) {
            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction(); // open session

                session1.persist(user);

                session1.getTransaction().commit(); // closing session
            }
            try (Session session2 = sessionFactory.openSession()) {
                session2.beginTransaction();


                session2.getTransaction().commit();
            }

            log.info("Successfully persisted user");
            System.out.println("OK");
        }
    }
}