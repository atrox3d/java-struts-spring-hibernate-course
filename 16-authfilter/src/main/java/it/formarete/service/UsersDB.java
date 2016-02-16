package it.formarete.service;

import it.formarete.model.User;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class UsersDB {
	private final static Map<String, User> USERS = new HashMap<String, User>();
	final static Logger logger = Logger.getLogger(UsersDB.class);
	
	static {
		logger.info("WORKDIR:" + System.getProperty("user.dir"));
		logger.info("**************************");
		logger.info("static init");
		logger.info("**************************");
		User user = new User();
		user.setUsername("giancarlo");
		user.setPassword("magalli");
		USERS.put(user.getUsername(), user);
		logger.info("add user:" + user);
		logUsers();
	}

	public static User get(String username) {
		logger.info("get user:" + username + "=" + USERS.get(username));
		return USERS.get(username);
	}
	
	public static void logUsers() {
		logger.info("--------------------------");
		logger.info("users list:");
		logger.info("--------------------------");
		for(User u: USERS.values()) {
			logger.info(u);
		}
		logger.info("--------------------------");
	}

	private UsersDB() {
	}
}
