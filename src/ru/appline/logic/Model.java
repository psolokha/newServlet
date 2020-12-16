package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable{
	
	private static final Model instance = new Model();
	private final Map<Integer, User> model;
	
	public static Model getInstance() {
		return instance;
	}
	
	private Model() {
		model = new HashMap<>();
		
		model.put (1, new User("Pavel", "Solokha", 10000));
		model.put (2, new User("Ivan", "Ivanov", 15000));
		model.put (3, new User("Petr", "Petrov", 20000));
		model.put (4, new User("thisUser", "toDelete", 1));
	}
	
	public void add(User user, int id) {
		model.put(id, user);
	}
	
	public Map<Integer, User> getFromList() {
		return model;
	}
	
	public User getUser(int id) {
		return model.get(id);
	}
	
	public void delUser(int id) {
		model.remove(id);
	}

}
