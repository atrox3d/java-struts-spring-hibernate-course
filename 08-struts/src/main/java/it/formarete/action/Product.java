package it.formarete.action;

import org.apache.log4j.Logger;

public class Product {
	
	final static Logger logger = Logger.getLogger(Product.class);
	
	private int id;
	private String name;
	private float price;
	
	public int getId() {
		logger.info("id:" + id);
		return id;
	}
	public void setId(int id) {
		logger.info("id:" + id);
		this.id = id;
	}
	public String getName() {
		logger.info("name:" + name);
		return name;
	}
	public void setName(String name) {
		logger.info("name:" + name);
		this.name = name;
	}
	public float getPrice() {
		logger.info("price:" + price);
		return price;
	}
	public void setPrice(float price) {
		logger.info("price:" + price);
		this.price = price;
	}
	
	public String execute() {
		logger.info("success");
		return "success";
	}

}
