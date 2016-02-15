package it.formarete.action;

import java.util.HashMap;
import java.util.List;

import it.formarete.model.Todo;
import it.formarete.services.TodoDB;
//import it.formarete.services.TodoDBSingleton;





import com.opensymphony.xwork2.ActionSupport;

public class TodoList extends ActionSupport {
	private static final long serialVersionUID = -4244760340526310322L;
	
	private String task;
	private int id;

	public int 			getId()					{return id;}
	public void			setId(int id)			{this.id = id;}
	public String		getTask()				{return task;}
	public void			setTask(String task)	{this.task = task;}
	public List<Todo>	getList()				{return TodoDB.getInsance().getAll();}

	public String delete() throws Exception {
		TodoDB.getInsance().delete(id);
		return execute();
	}
	
	public String confirmDeletion() {
		return SUCCESS;
	}
	
	public String deleteAll() throws Exception {
		TodoDB.getInsance().deleteAll();
		return execute();
	}

	public String add() throws Exception {
		Todo todo = new Todo();
		todo.setTask(task);
		TodoDB.getInsance().save(todo);
		return execute();
	}
	
	public String edit() {
		Todo todo = TodoDB.getInsance().load(id);
		setTask(todo.getTask());
		return SUCCESS;
	}

	public String update() throws Exception {
		Todo todo = TodoDB.getInsance().load(id);
		todo.setTask(task);
		TodoDB.getInsance().update(id, todo);
		return execute();
	}

	@Override
	public String execute() throws Exception {
		getList();
		setTask(null);
		setId(0);
		return SUCCESS;
	}

	
}
