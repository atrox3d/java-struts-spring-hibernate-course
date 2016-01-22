package it.formarete.service;
import it.formarete.model.*;
import java.util.Map;
import java.util.HashMap;

public class UsersDB {
	private final static Map<String, User> USERS= new HashMap<String, User>();
	
	static {
		User user = new User();
		
		user.setUsername("giancarlo");
		user.setPassword("magalli");
		
		USERS.put(user.getUsername(), user)	;
	}
	
	public static User get(String username) {
		return USERS.get(username);
	}
}
