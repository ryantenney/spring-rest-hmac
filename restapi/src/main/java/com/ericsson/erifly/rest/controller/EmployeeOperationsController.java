package com.ericsson.erifly.rest.controller;

import java.util.UUID;

import javax.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ericsson.erifly.domain.Employee;


@Named
@RequestMapping("v1/employee/operations")
@Slf4j
public class EmployeeOperationsController {
	
	
	@RequestMapping(value="/create" , method = RequestMethod.POST)
	public @ResponseBody Employee create(@RequestBody Employee user) {
		log.info("Creating new user {}", user);
		user.setId(UUID.randomUUID().toString());
		
		log.info("New user id = {}" , user.getId());
		
		return user;
	}
	
	
	@RequestMapping(value = "findone/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Employee findOne(@PathVariable(value = "id") String id) {
		log.info("Finding Employee with id {}", id);
		Employee user = new Employee();
        user.setFirstName("Dhrubo");
        user.setLastName("KAYAL");
        user.setId(id);
        return user;
    }
	
}
