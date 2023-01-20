package com.helper;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.*;


public class FactoryProvider {

	public static SessionFactory factory;
	
	// method having retrun type interface
	public static SessionFactory getFactory() {
		
		
		if(factory==null) {
		
			factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
	
	public void closeFactory() {
		if(factory.isOpen()) {
			factory.close();
		}
	}
	
	
}
