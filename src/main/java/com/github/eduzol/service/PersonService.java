package com.github.eduzol.service;

import java.util.List;

import com.github.eduzol.domain.Person;


public interface PersonService {

	void sort(List<Person> people) throws Exception;

}