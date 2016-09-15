package com.github.eduzol.controller;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.eduzol.domain.Account;
import com.github.eduzol.service.AccountSorter;
import com.google.common.base.Stopwatch;

@Api(name="Educational Services API" , description = "API functionality for managing services Accounts")
@ApiVersion(since = "1.0")
@Controller
public class DemoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private AccountSorter accountSorter ;
	
	@Autowired
	public void setAccountSorter(AccountSorter accountSorter) {
		this.accountSorter = accountSorter;
	}

	@ApiMethod(description="Sample demo for Service Account funcitonality. Accounts will be sorted according to specified business rules")
	@RequestMapping(path ="/demo" , method=RequestMethod.GET)
    public @ResponseBody List<Account> demo() throws Exception {
        
		Stopwatch stopwatch = Stopwatch.createStarted();
        		
    	List<Account> accounts = Arrays.asList(
				  new Account("Eduardo","Zola", 32, "Male", false),
				  new Account("Anthony","Zola", 32, "Male", false),
				  new Account("Hovanes","Gambaryan", 35, "Male", false),
				  new Account("Lisa","Simpson", 25, "Female", true), 
				  new Account("Lisa","Coleman", 25, "Female", true));
    	
    	accountSorter.sort(accounts);
    	
    	stopwatch.stop(); 
    	long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
    	logger.info("time : " + millis ); 
    	return accounts;
    	
    }
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleAllException(Exception ex) {
		return "\"there was an error fulfilling this request\"";
	}
	
	
}