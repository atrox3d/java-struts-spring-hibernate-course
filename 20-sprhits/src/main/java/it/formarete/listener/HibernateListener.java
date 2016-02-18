package it.formarete.listener;

import it.formarete.service.HibernateUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class HibernateListener implements ServletContextListener{

	final static Logger logger = Logger.getLogger(HibernateListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("***************** contextInitialized **********************");
		HibernateUtils.getSessionFactory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("***************** contextDestroyed **********************");
		HibernateUtils.getSessionFactory().close();
	}

}
