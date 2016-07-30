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
 */
public class HibernateManager {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
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

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}