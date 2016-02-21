package com.theopentutorials.ejb3;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorld {

    public HelloWorldBean() {
    }
    
    public String sayHello() {
    	return "Hello World!";
    }

}
