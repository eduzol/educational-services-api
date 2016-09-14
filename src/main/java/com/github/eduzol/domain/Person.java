package com.github.eduzol.domain;

public class Person {

	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private Boolean isInstructor;
	
	public Person(String firstName, String lastName, Integer age, String gender, Boolean isInstructor) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.isInstructor = isInstructor;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Boolean getIsInstructor() {
		return isInstructor;
	}
	public void setIsInstructor(Boolean isInstructor) {
		this.isInstructor = isInstructor;
	}
}
