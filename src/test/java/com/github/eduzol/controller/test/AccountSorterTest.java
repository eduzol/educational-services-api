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
import com.github.eduzol.domain.Account;
import com.github.eduzol.service.AccountSorter;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebApp.class)
@WebAppConfiguration
public class AccountSorterTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccountSorter personService;
	
	@Test
	public void testPersonServiceByFirstAndLastName() throws Exception{
		//in data access application, mock Dao to generate this data	
		List<Account> sampleValues = Arrays.asList(
				  new Account("Eduardo","Zola", 32, "Male", false),
				  new Account("Anthony","Zola", 32, "Male", false),
				  new Account("Hovanes","Gambaryan", 35, "Male", true),
				  new Account("Lisa","Simpson", 25, "Female", true), 
				  new Account("Lisa","Coleman", 25, "Female", true));
		
		List<Account> expectedValues = Arrays.asList(
				  new Account("Lisa","Coleman", 25, "Female", true),
				  new Account("Hovanes","Gambaryan", 35, "Male", true),
				  new Account("Lisa","Simpson", 25, "Female", true),
				  new Account("Anthony","Zola", 32, "Male", false),
				  new Account("Eduardo","Zola", 32, "Male", false) );

		logger.debug("before sorting: " + Arrays.toString(sampleValues.toArray()));
		
		personService.sort(sampleValues);
		
		logger.debug("after sorting: " + Arrays.toString(sampleValues.toArray()));
		
		assertEquals(sampleValues, expectedValues);
		assertNotEquals(sampleValues, Lists.reverse(expectedValues)  );
		
	}
	
	
}
