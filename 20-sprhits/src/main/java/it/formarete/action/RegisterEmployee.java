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
	private Employee employee;
	private EmployeeDAO dao;

	public List<Employee>	getEmployees()							{return employees;}
	public void				setEmployees(List<Employee> employees)	{this.employees = employees;}
	public String			getName()								{return name;}
	public void				setName(String name)					{this.name = name;}
	public float			getSalary()								{return salary;}
	public void				setSalary(float salary)					{this.salary = salary;}
	public Employee 		getEmployee()							{return employee;}
	public void 			setEmployee(Employee employee)			{this.employee = employee;}
	
	public EmployeeDAO getDao() {return dao;}
	public void setDao(EmployeeDAO dao) {this.dao = dao;}
	
	@Override
	public String execute() throws Exception {
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
