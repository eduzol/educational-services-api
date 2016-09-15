package com.github.eduzol.domain;

public class Student extends Account {

	public Student(String firstName, String lastName, Integer age, String gender) {
		super(firstName, lastName, age, gender, false);
	}

}
