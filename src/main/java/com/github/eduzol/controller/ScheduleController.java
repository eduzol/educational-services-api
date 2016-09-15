package com.github.eduzol.controller;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiQueryParam;
import org.jsondoc.core.annotation.ApiVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.eduzol.domain.Response;
import com.github.eduzol.domain.Schedule;

@Api(name="Schedule API" , description = "API functionality for school schedules")
@ApiVersion(since = "1.0")
@Controller
public class ScheduleController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ApiMethod(description="create new class schedule")
	@RequestMapping( path = "/schedule" , method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Response createSchedule(@ApiQueryParam(name="Schedule", description="Schedule data") 
								@RequestParam Schedule scheduleData ) {
		//TODO implement feature
		logger.warn("FEATURE NOT IMPLEMENTED");
		return new Response(0, "Success");
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Response handleAllException(Exception ex) {
		return new Response(-1 , "An error has ocurred");
	}
	
}
