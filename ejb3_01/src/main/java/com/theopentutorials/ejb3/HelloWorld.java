package com.theopentutorials.ejb3;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {
	public String sayHello();
}
