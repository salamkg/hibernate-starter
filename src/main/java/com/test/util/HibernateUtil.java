package com.test.util;

import com.test.converter.BirthdayConverter;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        Configuration config = new Configuration();
        config.addAttributeConverter(new BirthdayConverter());
        config.configure();

        return config.buildSessionFactory();
    }

}
