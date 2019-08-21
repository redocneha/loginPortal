package com.sapient.data.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.data.model.User;
import com.sapient.data.service.DataService;


@RestController
@RequestMapping("/api/data")
public class DataController {
	
	@Autowired
	DataService dataService;
	
	@PostMapping("/user")
	public Optional<User> getUser(@RequestBody User user) {
		Optional<User> optional = dataService.getUserForAuthentication(user);
		return optional;
	}
	
	@PostMapping("/update")
	public int update(@RequestBody User user) {
		return dataService.changePassword(user);
	}
}
