package it.formarete.action;

import java.util.List;

import it.formarete.model.Employee;
import it.formarete.service.EmployeeDAO;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterEmployee extends ActionSupport{

	private static final long serialVersionUID = -7960338327970819308L;
	private String name;
	private float salary;
	
	private List<Employee> employees;
	
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String execute() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = new Employee();
		employee.setName(name);
		employee.setSalary(salary);
		dao.save(employee);
		
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
