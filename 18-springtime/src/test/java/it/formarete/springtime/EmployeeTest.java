package it.formarete.springtime;

import org.junit.Test;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {

	@Test
	public void testInjection() {
		//ApplicationContext
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		  
		Employee employee = (Employee) context.getBean("emp");
		assertEquals("giancarlo", employee.getName());
		assertEquals(1000f, employee.getSalary(), 0f);
		assertEquals("torino", employee.getAddress().getCity());
		
		context.close();
	}

}
