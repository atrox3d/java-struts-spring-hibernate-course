package it.formarete.service;

import it.formarete.model.User;

import java.util.HashMap;
import java.util.Map;

public class UsersDB {
	private final static Map<String, User> USERS = new HashMap<String, User>();

	static {
		User user = new User();
		user.setUsername("giancarlo");
		user.setPassword("magalli");
		USERS.put(user.getUsername(), user);
	}

	public static User get(String username) {
		return USERS.get(username);
	}

	private UsersDB() {
	}
}
