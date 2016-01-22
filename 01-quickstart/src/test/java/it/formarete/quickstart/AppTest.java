package it.formarete.quickstart;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	public void testGetName() {
		App app = new App();
		app.setName("forma-re-te");
		assertEquals("forma-re-te", app.getName());
	}
}
