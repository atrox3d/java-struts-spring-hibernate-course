package it.formarete.spruts.action;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

	private static final long serialVersionUID = -3050899923340607526L;
	private String message;
	private String username;
	
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
	
	public String execute() {
		if("magalli".equals(username)) {
			return SUCCESS;
		}
		return ERROR;
	}
}
