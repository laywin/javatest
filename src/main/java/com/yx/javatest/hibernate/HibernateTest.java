/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-07-27 14:00 创建
 *
 */
package com.yx.javatest.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yanqing@yiji.com
 */
public class HibernateTest {

    @Test
    public void testHibernateSave(){
        SessionFactory sessionFactory = null;
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save( new Event( "Our very first event!", new Date() ) );
            session.save( new Event( "A follow up event", new Date() ) );
            session.load( Event.class, 1L);
            session.getTransaction().commit();
            session.close();

            session = sessionFactory.openSession();
            session.beginTransaction();
            List result = session.createQuery( "from Event" ).list();
            for ( Event event : (List<Event>) result ) {
                System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
            }
            session.getTransaction().commit();
            session.close();

        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    @Test
    public void testHibernateGet(){
        SessionFactory sessionFactory = null;
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();
//            session.get(Event.class, Serializable.class);

        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }
}
