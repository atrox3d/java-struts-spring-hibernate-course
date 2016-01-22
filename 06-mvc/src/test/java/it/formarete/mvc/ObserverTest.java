package it.formarete.mvc;

import junit.framework.TestCase;

public class ObserverTest extends TestCase {
	private View view;
	private Model model;
	
	
	public void setUp() {
		view = new View();
		model = new Model();
	}

	public void testViewInit() {
		assertEquals("<h1>hello nobody</h1>", view.getHtml());
	}
	
	public void testPublish() {
		
		model.addSubscriber(view);
		model.setAttribute("world");
		model.publish(model.getAttribute());
		
		assertEquals("<h1>hello world!</h1>", view.getHtml());
	}
}
