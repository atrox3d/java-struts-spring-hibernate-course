package com.theopentutorials.ejb3;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorld {

    public HelloWorldBean() {
    	System.out.println("helloworldbean:constructor");
    }
    
    public String sayHello() {
    	System.out.println("helloworldbean:sayHello");
    	return "Hello World!";
    }

}
