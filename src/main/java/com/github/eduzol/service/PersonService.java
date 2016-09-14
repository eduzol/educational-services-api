package com.github.eduzol.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.eduzol.domain.Person;
import com.google.common.collect.ComparisonChain;

@Service
public class PersonService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void sort(List<Person> people ) throws Exception {
		  
		logger.debug("attempt to sort  " + people.size() + " objects ");
		Collections.sort(people, new Comparator<Person>() {  
		    @Override  
		    public int compare(Person p1, Person p2) {
		    	logger.trace("Comparing p1=" + p1+ " , p2=" + p2 );
		        return ComparisonChain.start().
		        		compare(p1.getLastName(), p2.getLastName()).
		        		compare(p1.getFirstName(), p2.getFirstName())
		        		.result();   
		    }  
		});  
		
	}
}
