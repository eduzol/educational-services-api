package com.github.eduzol.controller;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.eduzol.domain.Greeting;


@Controller
@RequestMapping("/")
public class AppController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
           	
    	logger.info("greeting request for  " + name);
    	return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}