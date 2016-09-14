package com.github.eduzol.controller.test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.eduzol.WebApp;
import com.github.eduzol.domain.Person;
import com.github.eduzol.service.PersonService;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebApp.class)
@WebAppConfiguration
public class PersonServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonService personService;
	
	@Test
	public void testPersonServiceByFirstAndLastName() throws Exception{
		//in data access application, mock Dao to generate this data	
		List<Person> sampleValues = Arrays.asList(
				  new Person("Eduardo","Zola", 32, "Male", false),
				  new Person("Anthony","Zola", 32, "Male", false),
				  new Person("Hovanes","Gambaryan", 35, "Male", true),
				  new Person("Lisa","Simpson", 25, "Female", true), 
				  new Person("Lisa","Coleman", 25, "Female", true));
		
		List<Person> expectedValues = Arrays.asList(
				  new Person("Lisa","Coleman", 25, "Female", true),
				  new Person("Hovanes","Gambaryan", 35, "Male", true),
				  new Person("Lisa","Simpson", 25, "Female", true),
				  new Person("Anthony","Zola", 32, "Male", false),
				  new Person("Eduardo","Zola", 32, "Male", false) );

		logger.debug("before sorting: " + Arrays.toString(sampleValues.toArray()));
		
		personService.sort(sampleValues);
		
		logger.debug("after sorting: " + Arrays.toString(sampleValues.toArray()));
		
		assertEquals(sampleValues, expectedValues);
		assertNotEquals(sampleValues, Lists.reverse(expectedValues)  );
		
	}
	
	
}
