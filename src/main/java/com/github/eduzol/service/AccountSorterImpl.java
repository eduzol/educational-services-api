package com.github.eduzol.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.eduzol.domain.Account;
import com.google.common.collect.ComparisonChain;

@Service
public class AccountSorterImpl implements AccountSorter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/* (non-Javadoc)
	 * @see com.github.eduzol.service.PersonService#sort(java.util.List)
	 */
	@Override
	public void sort(List<Account> people ) throws Exception {
		  
		logger.debug("attempt to sort  " + people.size() + " objects ");
		Collections.sort(people, new Comparator<Account>() {  
		    @Override  
		    public int compare(Account p1, Account p2) {
		    	logger.trace("Comparing p1=" + p1+ " , p2=" + p2 );
		        return ComparisonChain.start().
		        		compare(p1.getLastName(), p2.getLastName()).
		        		compare(p1.getFirstName(), p2.getFirstName()).
		        		compare(p1.getAge(), p2.getAge()).
		        		compare(p1.getGender(), p2.getGender()).
		        		result();   
		    }  
		});  
		
	}
}
