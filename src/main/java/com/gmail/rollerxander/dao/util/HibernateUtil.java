package com.gmail.rollerxander.dao.util;

import com.gmail.rollerxander.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Java on 27.06.2016.
 */
public class HibernateUtil {

    private static SessionFactory factory = init();

    private HibernateUtil() {
    }

    public static Session getSession() {
        return factory.openSession();
    }

    public static void closeFactory() {
        factory.close();
    }

    private static SessionFactory init() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure().build();
        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Employee.class)
                .buildMetadata();
        return metadata.buildSessionFactory();
    }
}
