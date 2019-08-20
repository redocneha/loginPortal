package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SecurityQuestion;
import com.example.demo.model.User;
import com.example.demo.service.SecurityQuestionService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class Mycontroller {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityQuestionService securityquestionService;

	@GetMapping(value = "/securityquestions")
	public List<SecurityQuestion> securityquestions() {
		System.out.println("inside security questions .....");
		return securityquestionService.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping(path = "/register")
	public void saveProduct(@RequestBody User user) {
		System.out.println("inside Save .....");
		System.out.println(user);
		try {
			userService.saveUser(user);
	    }
	    catch (DataIntegrityViolationException e) {
	        System.out.println("history already exist");
	    }
	}

}
