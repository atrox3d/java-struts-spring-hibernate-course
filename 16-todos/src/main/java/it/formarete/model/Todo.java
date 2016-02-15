package it.formarete.model;

public class Todo {
	private int id;
	private String task;
	private boolean done;
	
	public int		getId() 				{ return id; }
	public void		setId(int id)			{ this.id = id; }
	
	public String	getTask()				{ return task; }
	public void		setTask(String task)	{ this.task = task; }
	
	public boolean	isDone() 				{ return done; }
	public void		setDone(boolean done)	{ this.done = done; }
}
