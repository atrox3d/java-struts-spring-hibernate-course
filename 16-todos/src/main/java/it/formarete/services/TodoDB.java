package it.formarete.services;

import it.formarete.model.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TodoDB {
	//private List<Todo> todos = new ArrayList<Todo>();
	private HashMap<Integer, Todo> todos;
	private int id;
	private static TodoDB tododb;
	
	public static TodoDB getInsance() {
		if(tododb == null) {
			tododb = new TodoDB();
		}
		return tododb;
	}

	
	private TodoDB() {
		todos = new HashMap<Integer, Todo>();
		id = 0;
	}

	public int save(Todo todo) {
		//todos.add(todo);
		id++;
		todo.setId(id);
		todos.put(todo.getId(), todo);
		return id;
	}
	
	public void delete(int id) {
		todos.remove(id);
	}
	
	public Todo load(int id) {
		return todos.get(id);
	}
	
	public int update(int id, Todo todo) {
		todos.put(id, todo);
		return id;
	}
	
	public List<Todo> getAll() {
	//public HashMap<Integer, Todo> getAll() {
		return new ArrayList<Todo>(todos.values());
	}
	
	public void deleteAll() {
		todos.clear();
	}
}
