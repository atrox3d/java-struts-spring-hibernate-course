package it.formarete.springtime;

public class Employee {
	private String name;
	private float salary;
	private Address address;
	public String	getName()				{return name;}
	public void		setName(String name)	{this.name = name;}
	public float	getSalary()				{return salary;}
	public void		setSalary(float salary)	{this.salary = salary;}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
