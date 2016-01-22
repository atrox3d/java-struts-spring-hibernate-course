package it.formarete.quickstart;

import java.io.Serializable;

public class App implements Serializable {

	private static final long serialVersionUID = 7056895419110277472L;
	private String name;

	public App() {

	}

	public App(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
