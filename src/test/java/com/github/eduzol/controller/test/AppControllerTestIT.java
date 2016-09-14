package com.github.eduzol.controller.test;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.github.eduzol.WebApp;
import com.github.eduzol.controller.AppController;
import com.github.eduzol.domain.Account;
import com.github.eduzol.service.AccountSorter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebApp.class)
@WebAppConfiguration
public class AppControllerTestIT {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private MockMvc mvc;
	
	@Autowired
	@InjectMocks
	private AppController appController;
	
	@Mock
	private AccountSorter accountSorterMock;
	
	
	@Before
	public void setUp(){
		mvc  = MockMvcBuilders.standaloneSetup(appController).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAppControllerEndpoint() throws Exception{
		logger.debug("Controller endpoint");
		mvc.perform(MockMvcRequestBuilders.get("/") )
			.andExpect(status().isOk())
			.andDo(print());
	}
	
	@Test
	public void testAppControllerEndpointException() throws Exception{
		  
	    doThrow(new Exception()).when(accountSorterMock).sort(Matchers.anyListOf(Account.class));
		mvc.perform(MockMvcRequestBuilders.get("/") )
		.andExpect(content().string("\"there was an error fulfilling this request\""))
		.andDo(print());
	}
		
	
}
