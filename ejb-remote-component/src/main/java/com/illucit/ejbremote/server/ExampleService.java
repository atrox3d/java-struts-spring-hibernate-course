package com.illucit.ejbremote.server;

import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface ExampleService {
	public String greet(String name);
	public Map<Object, Object> getSystemProperties();
}
