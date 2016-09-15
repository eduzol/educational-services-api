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

import com.github.eduzol.domain.Instructor;
import com.github.eduzol.domain.Response;


@Api(name="Instructor API" , description = "API functionality for instructor accounts")
@ApiVersion(since = "1.0")
@Controller
public class InstructorController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ApiMethod(description="retrieve information about a Instructor account")
	@RequestMapping( path = "/instructor" , method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Instructor getInstructor(@ApiQueryParam(name="InstructorId", description="Instructor Identifier") 
								@RequestParam Integer instructorId ) {
		//TODO implement feature
		logger.warn("FEATURE NOT IMPLEMENTED");
		return  new Instructor("Eduardo","Zola", 32, "Male");
	} 
	
	@ApiMethod(description="create new student account")
	@RequestMapping( path = "/instructor" , method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Response createInstructor(@ApiQueryParam(name="Instructor", description="Instructor data") 
								@RequestParam Instructor instructorData ) {
		//TODO implement feature
		logger.warn("FEATURE NOT IMPLEMENTED");
		return new Response(0, "Success");
	} 
	
	
	@ApiMethod(description="delete a student account")
	@RequestMapping( path = "/instructor" , method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Response updateInstructor(@ApiQueryParam(name="StudentId", description="Instructor Identifier") 
								@RequestParam Integer instructorId,
								@ApiQueryParam(name="Instructor", description="Instructor data") 
								@RequestParam Instructor instructorData	) {
		//TODO implement feature
		logger.warn("FEATURE NOT IMPLEMENTED");
		return new Response(0, "Success");
	} 
	
	@ApiMethod(description="delete a student account")
	@RequestMapping( path = "/instructor" , method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Response deleteInstructor(@ApiQueryParam(name="InstructorId", description="Instructor Identifier") 
								@RequestParam Integer instructorId ) {
		
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
