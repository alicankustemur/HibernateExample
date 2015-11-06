package com.alicankustemur.hibernate;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.alicankustemur.hibernate.entity.User;

public class App
{

	private static SessionFactory configureSessionFactory() throws HibernateException
	{
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory()
	{
		return configureSessionFactory();

	}

	public static void main(String[] args)
	{

		SessionFactory sessionFactory = getSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		User user = new User(1, "name", "surname", new Date());
		session.save(user);

		session.getTransaction().commit();
		session.close();

		user = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (User)session.get(User.class, 1);
		System.out.println(user.getName());
	}
}
