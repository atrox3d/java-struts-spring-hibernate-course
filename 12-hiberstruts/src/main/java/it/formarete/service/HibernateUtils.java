package it.formarete.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static SessionFactory singleton;
	
	public static SessionFactory getSessionFactory() {
		if(singleton==null) {
			Configuration cfg = new Configuration();
			cfg.configure();
			ServiceRegistry registry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties())
					.build();
			singleton = cfg.buildSessionFactory();
		}
		
		return singleton;
	}
	
	public static void closeSessionFactory() {
		if(singleton!=null) {
			singleton.close();
			singleton = null;
		}
	}

}
