package it.formarete.service;

import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import it.formarete.listener.HibernateListener;

public class HibernateUtils {
	private static SessionFactory singleton;
	final static Logger logger = Logger.getLogger(HibernateUtils.class);
	
	public static SessionFactory getSessionFactory() {
		logger.info("***************** getSessionFactory **********************");
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
}
