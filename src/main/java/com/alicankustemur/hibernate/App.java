package com.alicankustemur.hibernate;

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
		Configuration configuration = new Configuration();
		configuration.configure();
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

		User user = new User(1, "user");
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}
}
