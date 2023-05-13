package org.framework.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {// Create properties for Hibernate configuration
            Properties hibernateProps = new Properties();
            hibernateProps.put(Environment.DRIVER, "org.postgresql.Driver");
            hibernateProps.put(Environment.URL, "jdbc:postgresql://localhost:5432/framework");
            hibernateProps.put(Environment.USER, "postgres");
            hibernateProps.put(Environment.PASS, "postgres");
            hibernateProps.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            hibernateProps.put(Environment.SHOW_SQL, "true");
            hibernateProps.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            hibernateProps.put(Environment.HBM2DDL_AUTO, "create");
            // Build the configuration object and register entity classes
            Configuration configuration = new Configuration();
            configuration.setProperties(hibernateProps);
//            configuration.addAnnotatedClass(Event.class);
//            configuration.addAnnotatedClass(Guests.class);
//            configuration.addAnnotatedClass(Adress.class);
//            configuration.addAnnotatedClass(SocialMedia.class);

            // Build the ServiceRegistry and create the SessionFactory
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }}
    public static SessionFactory getSessionFactory() {
        return sessionFactory; }}
