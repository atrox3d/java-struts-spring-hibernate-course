package it.formarete.action;

import java.util.List;

import org.apache.log4j.Logger;

import it.formarete.model.Employee;
import it.formarete.service.EmployeeDAO;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterEmployee extends ActionSupport{

	private static final long serialVersionUID = -7960338327970819308L;
	private String name;
	private float salary;
	final static Logger logger = Logger.getLogger(RegisterEmployee.class);
	
	private List<Employee> employees;
	
	
	public List<Employee> getEmployees() {
		logger.info("getEmployees");
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		logger.info("setEmployees");
		this.employees = employees;
	}
	public String getName() {
		logger.info("getName:" + name);
		return name;
	}
	public void setName(String name) {
		logger.info("setName:" + name);
		this.name = name;
	}
	public float getSalary() {
		logger.info("getSalary:" + salary);
		return salary;
	}
	public void setSalary(float salary) {
		logger.info("setSalary:" + salary);
		this.salary = salary;
	}
	@Override
	public String execute() throws Exception {
		logger.info("execute");
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = new Employee();
		employee.setName(name);
		employee.setSalary(salary);
		logger.info("save employee" + employee);
		dao.save(employee);
		logger.info("employees.getall");
		employees = dao.getAll();
		
		
		return SUCCESS;
	}
	
	public boolean getIsBroke() {
		return salary == 0;
	}
	
	public boolean getIsWanted() {
		return salary < 0;
	}
	
	
}
