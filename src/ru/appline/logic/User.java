package ru.appline.logic;

import lombok.Getter;
import lombok.Setter;

public class User {
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String surname;
	@Getter @Setter
	private double salary;
	
	public User(String name, String surname, double salary) {
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}
}
