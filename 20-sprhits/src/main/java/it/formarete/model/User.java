package it.formarete.model;

import it.formarete.service.UserDAO;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport{

	private static final long serialVersionUID = 6521272548418949529L;
	private int id;
	private String name;
	private UserDAO dao;
	
	public int		getId()					{return id;}
	public void		setId(int id)			{this.id = id;}
	public String	getName()				{return name;}
	public void		setName(String name)	{this.name = name;}
	public UserDAO	getDao()				{return dao;}
	public void		setDao(UserDAO dao)		{this.dao = dao;}
	
	@Override
	public String execute() throws Exception {
		dao.save(this);
		return SUCCESS;
	}
	
	

}
