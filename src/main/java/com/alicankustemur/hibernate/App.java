package com.alicankustemur.hibernate;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.alicankustemur.hibernate.entity.Adress;
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

		User user = new User();
		user.setName("ali can");
		user.setSurname("kuştemur");
		user.setJoinDate(new Date());

		User user2 = new User();
		user2.setName("özcan");
		user2.setSurname("");
		user2.setJoinDate(new Date());

		Adress adress = new Adress();
		adress.setStreet("5632");
		adress.setCity("Mersin");
		adress.setState("Türkiye");
		adress.setPincode("33040");

		user.setHomeAdress(adress);

		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();

		user = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (User)session.get(User.class, 1);
		System.out.println(user.getName());
	}
}
