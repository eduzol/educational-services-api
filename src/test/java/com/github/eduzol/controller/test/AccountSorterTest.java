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
	private AccountSorter accountSorter;
	
	@Test
	public void testAccountSorterByFirstAndLastName() throws Exception{
		//TODO in data access application, mock Dao to generate this data	
		List<Account> sampleValues = Arrays.asList(
				  new Account("Eduardo","Zola", 32, "Male", false),
				  new Account("Anthony","Zola", 32, "Male", false),
				  new Account("Hovanes","Gambaryan", 35, "Male", false),
				  new Account("Lisa","Simpson", 25, "Female", false), 
				  new Account("Lisa","Coleman", 25, "Female", false));
		
		List<Account> expectedValues = Arrays.asList(
				  new Account("Lisa","Coleman", 25, "Female", false),
				  new Account("Hovanes","Gambaryan", 35, "Male", false),
				  new Account("Lisa","Simpson", 25, "Female", false),
				  new Account("Anthony","Zola", 32, "Male", false),
				  new Account("Eduardo","Zola", 32, "Male", false) );

		logger.debug("before sorting: " + Arrays.toString(sampleValues.toArray()));
		
		accountSorter.sort(sampleValues);
		
		logger.debug("after sorting: " + Arrays.toString(sampleValues.toArray()));
		
		assertEquals(sampleValues, expectedValues);
		assertNotEquals(sampleValues, Lists.reverse(expectedValues)  );
		
	}
	
	@Test
	public void testAccountServiceByGender() throws Exception{
		//TODO in data access application, mock Dao to generate this data	
		List<Account> sampleValues = Arrays.asList(
				  new Account("Eduardo","Zola", 32, "Male", false),
				  new Account("Eduardo","Zola", 32, "Female", false),
				  new Account("Hovanes","Gambaryan", 35, "Male", false)
				  );
		
		List<Account> expectedValues = Arrays.asList(
				 new Account("Hovanes","Gambaryan", 35, "Male", false),
				 new Account("Eduardo","Zola", 32, "Female", false),
				 new Account("Eduardo","Zola", 32, "Male", false)
				 );

		logger.debug("before sorting: " + Arrays.toString(sampleValues.toArray()));
		
		accountSorter.sort(sampleValues);
		
		logger.debug("after sorting: " + Arrays.toString(sampleValues.toArray()));
		
		assertEquals(sampleValues, expectedValues);
		assertNotEquals(sampleValues, Lists.reverse(expectedValues)  );

	}
	
	@Test
	public void testAccountSorterByAge() throws Exception{
		
		List<Account> sampleValues = Arrays.asList(
				  new Account("Eduardo","Zola", 32, "Male", false),
				  new Account("Eduardo","Zola", 40, "Female", false),
				  new Account("Eduardo","Zola", 31, "Male", false),
				  new Account("Hovanes","Gambaryan", 35, "Male", false)
				  );
		
		List<Account> expectedValues = Arrays.asList(
				 new Account("Hovanes","Gambaryan", 35, "Male", false),
				 new Account("Eduardo","Zola", 31, "Male", false),
				 new Account("Eduardo","Zola", 32, "Male", false),
				 new Account("Eduardo","Zola", 40, "Female", false)
				 );

		logger.debug("before sorting: " + Arrays.toString(sampleValues.toArray()));
		
		accountSorter.sort(sampleValues);
		
		logger.debug("after sorting: " + Arrays.toString(sampleValues.toArray()));
		
		assertEquals(sampleValues, expectedValues);
		assertNotEquals(sampleValues, Lists.reverse(expectedValues)  );
	}
}
