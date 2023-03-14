package com.notetaker.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static SessionFactory getSessionFactory(){
		
		Configuration config = new Configuration();
		config.configure("com/notetaker/hibernate/configs/hibernate-cfg.xml");
		
		SessionFactory sfactory = config.buildSessionFactory();
		
		return sfactory;
		
	}

}
