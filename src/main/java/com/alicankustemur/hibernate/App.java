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
import com.alicankustemur.hibernate.entity.Vehicle;

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
		adress.setStreet("Street 1");
		adress.setCity("City 1");
		adress.setState("State 1");
		adress.setPincode("Pin Code 1");

		Adress adress2 = new Adress();
		adress2.setStreet("Street 2");
		adress2.setCity("City 2");
		adress2.setState("State 2");
		adress2.setPincode("Pin Code 2");

		user.getListOfAdress().add(adress);
		user.getListOfAdress().add(adress2);

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		user.setVehicle(vehicle);

		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();

		user = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (User)session.get(User.class, 1);
		session.close();
		System.out.println(user.getListOfAdress().size());

	}
}
