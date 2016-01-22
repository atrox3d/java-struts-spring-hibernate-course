package it.formarete.test;

import it.formarete.action.Product;
import junit.framework.TestCase;

public class ProductTestCase extends TestCase{
	
	public void testProduct() {
		Product product = new Product();
		product.setId(1);
		
		assertEquals(1, product.getId());
	}

}
