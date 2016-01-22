package it.formarete.action;

import it.formarete.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Welcome extends ActionSupport {

	private static final long serialVersionUID = 300593643361513335L;
	private User user;
	
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() {
		user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstname("Pippo");
		user.setLastname("Baudo");
		return SUCCESS;
	}
	
}
