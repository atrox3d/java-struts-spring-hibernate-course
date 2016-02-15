package it.formarete.listener;

import it.formarete.action.RegisterEmployee;
import it.formarete.service.HibernateUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class HibernateListener implements ServletContextListener{
	final static Logger logger = Logger.getLogger(RegisterEmployee.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("getSessionFactory");
		HibernateUtils.getSessionFactory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtils.getSessionFactory().close();
		logger.info("getSessionFactory.close");
	}

}
