package com.github.eduzol.domain;

public class Instructor extends Account {

	public Instructor(String firstName, String lastName, Integer age, String gender) {
		super(firstName, lastName, age, gender,true);
	}
}
