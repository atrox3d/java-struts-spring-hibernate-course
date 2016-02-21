package ejb1;

import org.junit.Test;

import com.theopentutorials.ejb3.HelloWorld;
import com.theopentutorials.ejb3.HelloWorldBean;

import junit.framework.TestCase;

public class HelloWorldEJBTestCase extends TestCase {

	@Test
	public void test() {
		HelloWorld hw = new HelloWorldBean();
		assertEquals("Hello World!", hw.sayHello());
	}

}
