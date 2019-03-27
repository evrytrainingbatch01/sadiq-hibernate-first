package com.evry.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.evry.hibernate.pojo.Aero;

public class HibernateDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aero aero = new Aero();
		aero.setAid(1);
		aero.setAcolor("blue");
		aero.setAname("AirAsia");
		
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(sr).getMetadataBuilder().build();
		
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(aero);
		session.getTransaction().commit();
		
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	}

}
