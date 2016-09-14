package com.github.eduzol.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebApp.class)
@WebAppConfiguration
public class AppControllerTestIT {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private MockMvc mvc;
	
	
	@Autowired 
	private AppController appController;
	
	@Before
	public void setUp(){
		mvc  = MockMvcBuilders.standaloneSetup(appController).build();
	}
	
	@Test
	public void testAppControllerEndpoint() throws Exception{
		logger.debug("Controller endpoint");
		mvc.perform(MockMvcRequestBuilders.get("/") )
			.andExpect(status().isOk())
			.andDo(print());
	}
		
	
}
