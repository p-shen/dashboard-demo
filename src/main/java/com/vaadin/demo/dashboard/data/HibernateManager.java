package com.vaadin.demo.dashboard.data;

import com.vaadin.demo.dashboard.data.db.models.*;
import com.vaadin.demo.dashboard.domain.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Peter on 2016-07-28.
 *
 * Hibernate manager class used to configure Hibernate and initialize/retrieve Hibernate sessions
 */
public class HibernateManager {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();

            //Hibernate mappings added manually if ran directly from IDE since the mappings
            //in the hibernate.cfg.xml file is not picked up
            //TODO: removed in production code
            Class[] mappings = {
                    MoviesEntity.class,
                    LinksEntity.class,
                    AbridgedCastEntity.class,
                    AlternateIdsEntity.class,
                    PostersEntity.class,
                    RatingsEntity.class,
                    ReleaseDatesEntity.class,
                    Movie.class
            };
            for (int i = 0; i < mappings.length; i++) {
                configuration.addAnnotatedClass(mappings[i]);
            }
            configuration.configure();

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void close() throws HibernateException {
        ourSessionFactory.close();
    }
}